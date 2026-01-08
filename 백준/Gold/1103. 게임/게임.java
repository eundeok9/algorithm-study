import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean isCycle;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                if(s.charAt(j) == 'H') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
        }

        dp = new int[N][M];
        visited = new boolean[N][M];
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
            int nx = x + dx[d] * map[x][y];
            int ny = y + dy[d] * map[x][y];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[nx][ny] == -1) continue;

            if(visited[nx][ny]) {
                isCycle = true;
                return;
            }

            if(dp[nx][ny] <= cnt) {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1);
                visited[nx][ny] = false;
            }

        }
    }

}
