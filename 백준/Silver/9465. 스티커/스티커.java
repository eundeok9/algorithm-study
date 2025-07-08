import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];
            int[][] dp = new int[2][N];
            for(int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            for(int col=1; col<N; col++) {
                dp[0][col] = Math.max(dp[1][col-1] + sticker[0][col], dp[0][col-1]);
                dp[1][col] = Math.max(dp[0][col-1] + sticker[1][col], dp[1][col-1]);
            }

            int answer = Math.max(dp[0][N-1], dp[1][N-1]);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
