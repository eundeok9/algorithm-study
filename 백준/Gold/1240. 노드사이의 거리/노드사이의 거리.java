import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<List<Node>> graph;
    static class Node {
        int to, dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, l));
            graph.get(b).add(new Node(a, l));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int dist = bfs(start, end);
            sb.append(dist).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int start, int end) {
        int dist = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        queue.offer(new int[] {start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == end) {
                return cur[1];
            }

            for(Node nxt: graph.get(cur[0])) {
                if(!visited[nxt.to]) {
                    visited[nxt.to] = true;
                    queue.offer(new int[] {nxt.to, cur[1] + nxt.dist});
                }
            }
        }

        return dist;
    }
}