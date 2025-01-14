import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }

    public static int dfs(int x, int y) {
        // 이미 계산된 값이 있다면 반환
        if(dp[x][y] != 0) {
            return dp[x][y];
        }

        // 초기값
        dp[x][y] = 1;

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                if(map[x][y] < map[nx][ny]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                }
            }
        }

        return dp[x][y];
    }
}