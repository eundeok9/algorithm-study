import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] times = new int[N];
            int[] dp = new int[N];
            int[] inDegree = new int[N];
            List<List<Integer>> graph = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                graph.add(new ArrayList<>());
                times[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph.get(a).add(b);
                inDegree[b]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<N; i++) {
                if(inDegree[i] == 0) {
                    queue.offer(i);
                    dp[i] = times[i];
                }
            }

            while(!queue.isEmpty()) {
                int cur = queue.poll();

                for(int nxt: graph.get(cur)) {
                    dp[nxt] = Math.max(dp[nxt], dp[cur] + times[nxt]);
                    if(--inDegree[nxt] == 0) {
                        queue.offer(nxt);
                    }
                }
            }

            int W = Integer.parseInt(br.readLine());
            System.out.println(dp[W-1]);
        }
    }
}