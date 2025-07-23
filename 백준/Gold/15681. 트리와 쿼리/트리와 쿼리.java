import java.io.*;
import java.util.*;
public class Main {
    static int N, R, Q;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] subtreeSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

       graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        subtreeSize = new int[N+1];
        visited = new boolean[N+1];

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[query]).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int cur) {
        visited[cur] = true;
        int size = 1;

        for(int nxt: graph.get(cur)) {
            if(!visited[nxt]) {
                size += dfs(nxt);
            }
        }

        subtreeSize[cur] = size;
        return size;
    }
}