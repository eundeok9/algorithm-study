import java.io.*;
import java.util.*;
public class Main {
    static int N, M, V;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=0; i<=N; i++) {
            Collections.sort(graph.get(i));
        }

        sb = new StringBuilder();

        visited = new boolean[N+1];
        visited[V] = true;
        dfs(V);

        sb.append("\n");
        visited = new boolean[N+1];
        visited[V] = true;
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int v) {
        sb.append(v).append(" ");
        for(int nxt: graph.get(v)) {
            if(!visited[nxt]) {
                visited[nxt] = true;
                dfs(nxt);
            }
        }
    }

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        sb.append(V).append(" ");

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int nxt: graph.get(cur)) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    queue.offer(nxt);
                    sb.append(nxt).append(" ");
                }
            }
        }
    }
}
