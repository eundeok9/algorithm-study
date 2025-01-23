import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                visited[i][j] = true;
                backTracking(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    public static void backTracking(int r, int c, int depth, int sum) {
        if(depth == 4) {
            if(answer < sum) answer = sum;
            return;
        }

        for(int i=0; i<4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(!check(nr, nc)) continue;
            if(visited[nr][nc]) continue;

            if(depth == 2) {
                visited[nr][nc] = true;
                backTracking(r, c, depth+1, sum + map[nr][nc]);
                visited[nr][nc] = false;
            }

            visited[nr][nc] = true;
            backTracking(nr, nc, depth+1, sum + map[nr][nc]);
            visited[nr][nc] = false;
        }
    }

    static boolean check(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }
}