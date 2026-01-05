import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(dp[i][j] == 0) continue; // 올 수 없는 칸
                if(i==N-1 && j==N-1) continue; // 도착점

                int nx = i + map[i][j];
                int ny = j + map[i][j];

                if(nx < N) dp[nx][j] += dp[i][j];
                if(ny < N) dp[i][ny] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}