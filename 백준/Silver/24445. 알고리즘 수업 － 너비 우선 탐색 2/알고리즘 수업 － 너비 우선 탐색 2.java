import java.io.*;
import java.util.*;
public class Main {
    static int N, M, R;
    static List<List<Integer>> graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0; i<N; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        visited = new int[N];
        bfs(R-1);

        for(int i=0; i<N; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        int order = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int nxt: graph.get(cur)) {
                if(visited[nxt] == 0) {
                    visited[nxt] = ++order;
                    queue.add(nxt);
                }
            }
        }

    }
}
