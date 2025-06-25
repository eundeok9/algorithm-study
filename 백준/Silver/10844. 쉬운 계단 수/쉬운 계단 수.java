import java.io.*;
public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp[i][d]: i자리 계단 수 중 끝자리가 d인 경우의 수
        int[][] dp = new int[N + 1][10];

        for (int d = 1; d <= 9; d++) {
            dp[1][d] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int d = 0; d <= 9; d++) {
                if (d > 0)   dp[i][d] = (dp[i][d] + dp[i-1][d-1]) % MOD;
                if (d < 9)   dp[i][d] = (dp[i][d] + dp[i-1][d+1]) % MOD;
            }
        }

        // N자리 계단 수의 총합
        long answer = 0;
        for (int d = 0; d <= 9; d++) {
            answer = (answer + dp[N][d]) % MOD;
        }

        System.out.println(answer);
    }
}
