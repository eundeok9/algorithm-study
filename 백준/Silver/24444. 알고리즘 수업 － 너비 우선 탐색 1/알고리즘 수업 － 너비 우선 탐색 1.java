import java.io.*;
import java.util.*;
public class Main {
    static int N, M, R;
    static List<List<Integer>> graph;
    static int[] visited;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
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

        for(int i=0; i<N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new int[N];
        bfs();

        for(int i=0; i<N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        visited[R] = count++;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int nxt: graph.get(cur)) {
                if(visited[nxt] == 0) {
                    visited[nxt] = count++;
                    queue.add(nxt);
                }
            }
        }
    }
}