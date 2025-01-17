import java.io.*;
import java.util.*;
public class Main {
    static List<List<int[]>> graph;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 트리 정보를 2차원 배열에 저장

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true) {
                int neighbor = Integer.parseInt(st.nextToken());
                if (neighbor == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                graph.get(node).add(new int[]{neighbor, dist});
            }
        }

        // 임의의 노드(1)에서 가장 먼 노드 찾기
        int[] result1 = bfs(1);
        int farNode = result1[0];

        // 가장 먼 노드에서 다시 bfs를 수행하여 트리의 지름 찾기
        int[] result2 = bfs(farNode);
        int answer = result2[1];

        System.out.println(answer);
    }

    public static int[] bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int farNode = start;
        int maxDist = 0;

        queue.add(new int[] {start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int dist = cur[1];

            if(dist > maxDist) {
                maxDist = dist;
                farNode = node;
            }

            for(int[] edge: graph.get(node)) {
                int nextNode = edge[0];
                int nextDist = edge[1];

                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(new int[] {nextNode, dist + nextDist});
                }
            }
        }

        return new int[] {farNode, maxDist};
    }
}
