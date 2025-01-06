import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        boolean[] visited = new boolean[N];
        Queue<int[]> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(new int[] {0, 0}); // 현재 노드, depth
        int answer = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int depth = cur[1];
            if(depth > 2) break;
            for(int i=0; i<graph.get(node).size(); i++) {
                int next = graph.get(node).get(i);
                if(!visited[next]) {
                    if(depth + 1 > 2) continue;
                    visited[next] = true;
                    queue.add(new int[] {next, depth + 1});
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
