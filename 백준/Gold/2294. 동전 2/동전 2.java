import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=0; i<=K; i++) {
            for(int coin: coins) {
                if(i - coin >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);
    }
}