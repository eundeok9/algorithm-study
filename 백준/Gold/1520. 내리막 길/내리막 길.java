import java.io.*;
import java.util.*;
public class Main {
    static int N, M; // 세로, 가로
    static int[][] map;
    static int[][] dp;
    static int answer = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if(x == N-1 && y == M-1) {
            return 1;
        }

        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!isRange(nx, ny)) continue;

            if(map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }

    public static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}