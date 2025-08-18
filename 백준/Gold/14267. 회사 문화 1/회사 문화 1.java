import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> graph;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(i==1) continue;
            graph.get(num).add(i);
        }

        scores = new int[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            scores[n] += w;
        }

        dfs(1);
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(scores[i]).append(" " );
        }
        System.out.println(sb);

    }

    static void dfs(int cur) {
        for(int nxt: graph.get(cur)) {
            scores[nxt] += scores[cur];
            dfs(nxt);
        }
    }
}