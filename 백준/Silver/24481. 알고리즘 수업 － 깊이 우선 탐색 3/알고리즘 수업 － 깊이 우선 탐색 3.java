import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> graph;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
        d = new int[N];

        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0; i<N; i++) {
            Collections.sort(graph.get(i));
        }

        d[R] = 0;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(d[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int r) {
        for(int nxt: graph.get(r)) {
            if(d[nxt] == -1) {
                d[nxt] = d[r]+1;
                dfs(nxt);
            }
        }
    }
}