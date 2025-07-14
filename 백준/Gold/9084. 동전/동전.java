import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target+1];
            dp[0] = 1;
            for(int i=1; i<=N; i++) {
                int cur = coin[i];
                for(int j=cur; j<=target; j++) {
                    dp[j] += dp[j-cur];
                }
            }

            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
    }
}