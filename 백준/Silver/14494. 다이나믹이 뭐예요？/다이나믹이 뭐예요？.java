import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static final long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N][M];
        dp[0][0] = 1;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j-1] + dp[i-1][j-1]  + dp[i][j]) % MOD;
                }
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}