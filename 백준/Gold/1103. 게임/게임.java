import java.io.*;
import java.util.*;
public class Main {
    static boolean isCycle = false;
    static int N, M;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dp = new int[N][M];
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

    public static void dfs(int x, int y, int depth) {
        if(depth > max) {
            max = depth;
        }

        dp[x][y] = depth;

        for(int d=0; d<4; d++) {
            int nx = x + (dx[d] * (map[x][y] - '0'));
            int ny = y + (dy[d] * (map[x][y] - '0'));

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 'H') continue;

            if(visited[nx][ny]){
                isCycle = true;
                return;
            }

            if(dp[nx][ny] > depth) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1);
            visited[nx][ny] = false;
        }
    }
}
