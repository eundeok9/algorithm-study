import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int max = -1;
    static boolean isCycle = false;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N][M];
        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[0][0] = true;
        dfs(0, 0, 1);

        if(isCycle) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

    static void dfs(int x, int y, int cnt) {
        if(cnt > max) {
            max = cnt;
        }
        dp[x][y] = cnt;

        for(int d=0; d<4; d++) {
            int move = Character.getNumericValue(map[x][y]);

            int nx = x + (move * dx[d]);
            int ny = y + (move * dy[d]);

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 'H') continue;

            if(visited[nx][ny]) {
                isCycle = true;
                return;
            }

            if(dp[nx][ny] > cnt) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, cnt + 1);
            visited[nx][ny] = false;
        }
    }
}