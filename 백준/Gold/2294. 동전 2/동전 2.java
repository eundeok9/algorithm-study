import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 가치

        int[] coin = new int[N+1];
        for(int i=1; i<=N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K+1]; // dp[i]: i원을 만드는 동전의 개수
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=N; i++) {
            for(int j=coin[i]; j<=K; j++) {
                if(dp[j - coin[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
                }
            }
        }

        System.out.println((dp[K] == Integer.MAX_VALUE) ? -1 : dp[K]);
    }
}