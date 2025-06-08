import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        for(int i=1; i<=N; i++) {
            for(int j=0; j<i+1; j++) {
                if(j>0) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = arr[i][j] + dp[i-1][j];
                }
            }
        }

        int max = -1;
        for(int i=0; i<N+1; i++) {
            max = Math.max(max, dp[N][i]);
        }

        System.out.println(max);

    }
}