import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][N];
            for(int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][N];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            for(int j=1; j<N; j++) {
                dp[0][j] = Math.max(dp[1][j-1] + arr[0][j], dp[0][j-1]);
                dp[1][j] = Math.max(dp[0][j-1] + arr[1][j], dp[1][j-1]);
            }

            System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
        }
    }
}