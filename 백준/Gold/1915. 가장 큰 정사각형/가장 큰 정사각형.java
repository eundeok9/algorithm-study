import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 1) {
                    if(i==0 || j==0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                }

                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max*max);
    }
}
