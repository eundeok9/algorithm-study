import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] coins = {1, 2, 5, 7};

        for(int i=1; i<=N; i++) {
            for(int coin: coins) {
                if(i-coin >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        System.out.println(dp[N]);
    }
}