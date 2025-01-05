import java.io.*;
import java.util.*;
public class Main {
    static int N, M, r, c, d;
    static int[][] map;
    static int count = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r, c, d);
        System.out.println(count);
    }

    public static void dfs(int x, int y, int dir) {
        map[x][y] = -1; // 방문 표시

        for(int i=0; i<4; i++) {
            dir = (dir + 3) % 4; // 반시계 방향 90도 회전

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                // 청소되지 않은 빈칸이 있다면
                if(map[nx][ny] == 0) {
                    count++;
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }

        // 청소되지 않은 빈칸이 없다면
        int d = (dir+2) % 4; // 반대 방향 후진
        int nx = x + dx[d];
        int ny = y + dy[d];
        if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 1) {
            dfs(nx, ny, dir); // 바라보는 방향은 유지
        }
    }
}