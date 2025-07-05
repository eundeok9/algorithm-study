import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + dp[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + dp[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + dp[i][2];
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            answer = Math.min(dp[N-1][i], answer);
        }
        System.out.println(answer);
    }
}