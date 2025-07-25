import java.io.*;
public class Main {
    static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        for(int d=0; d<10; d++) {
            dp[1][d] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<=j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD;
                }
            }
        }

        int answer = 0;
        for(int d=0; d<10; d++) {
            answer = (answer + dp[N][d]) % MOD;
        }
        System.out.println(answer);
    }
}