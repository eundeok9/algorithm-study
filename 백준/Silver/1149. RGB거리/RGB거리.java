import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        int[][] map = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                int cost = Integer.parseInt(st.nextToken());
                map[i][j] = cost;
                if(i==0) {
                    dp[i][j] = cost;
                }
            }
        }

        for(int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            answer = Math.min(dp[N-1][i], answer);
        }
        System.out.println(answer);
    }
}