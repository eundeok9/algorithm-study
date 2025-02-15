import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[65][10]; // dp[i][j] (i: 자리 수, j: 시작하는 수)
        for(int i=0; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=64; i++) {
            for(int j=0; j<=9; j++) {
                for(int k=j; k<=9; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            long answer = 0;

            for(int i=0; i<=9; i++) {
                answer += dp[N][i];
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
