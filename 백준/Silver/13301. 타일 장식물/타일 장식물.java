import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];
        if(N==1) {
            System.out.println(4);
        } else {
            dp[1] = 1; dp[2] = 1;
            for(int i=3; i<=N; i++) {
                dp[i] = dp[i-2]+dp[i-1];
            }

            System.out.println(dp[N]*4+dp[N-1]*2);
        }
    }
}