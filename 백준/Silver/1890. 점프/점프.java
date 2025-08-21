import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static long[][] dp;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new long[N][N];
        for(int i=0; i<N; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    static long dfs(int x, int y) {

        if(x == N-1 && y == N-1) {
            return 1;
        }

        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for(int d=0; d<2; d++) {
            int nx = x + (dx[d] * map[x][y]);
            int ny = y + (dy[d] * map[x][y]);

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            dp[x][y] += dfs(nx, ny);
        }

        return dp[x][y];
    }
}
