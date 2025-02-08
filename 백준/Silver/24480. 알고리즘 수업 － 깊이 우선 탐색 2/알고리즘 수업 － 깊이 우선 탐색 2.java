import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> graph;
    static int[] visited;
    static int order = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

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
        dfs(R-1);

        for(int i=0; i<N; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void dfs(int start) {
        visited[start] = order++;

        for(int nxt: graph.get(start)) {
            if(visited[nxt] == 0) {
                dfs(nxt);
            }
        }
    }
}