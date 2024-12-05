import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int airCleaner = -1;
    static Queue<Dust> dusts = new LinkedList<>();
    public static class Dust {
        int x, y, w;
        public Dust(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 공기 청정기 위치
                if(airCleaner == -1 && map[i][j] == -1) {
                    airCleaner = i;
                }
            }
        }

        // 0. 미세먼지 위치 확인
        // 1. 미세먼지 확산
        // 2. 공기청정기 가동
        for(int i=0; i<T; i++) {
            checkDust();
            spreadDust();
            moveDust();
        }

        int res = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == -1) continue;
                res += map[i][j];
            }
        }
        System.out.println(res);

    }

    public static void checkDust() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == -1 || map[i][j] == 0) continue;
                dusts.add(new Dust(i, j, map[i][j]));
            }
        }

    }
    public static void spreadDust() {
        while(!dusts.isEmpty()) {
            Dust cur = dusts.poll();
            // 확산될 먼지 양이 아닌 경우
            if(cur.w < 5) continue;

            int amount = cur.w / 5;
            int cnt = 0;
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                // 범위를 벗어난 경우
                if(check(nx, ny)) continue;
                // 공기 청정기가 있는 경우
                if(map[nx][ny] == -1) continue;

                map[nx][ny] += amount;
                cnt++;
            }

            map[cur.x][cur.y] -= amount * cnt;
        }
    }

    public static boolean check(int x, int y) {
        return 0 > x || x >= R || 0 > y || y >= C;
    }

    public static void moveDust() {
        int top = airCleaner; // 공기청정기 윗 부분 행 위치
        int bottom = airCleaner + 1; // 공기청정기 아래 부분 행 위치

        // 공기청정기 위쪽 작동
        for(int i=top-1; i>0; i--) {
            map[i][0] = map[i-1][0];
        }
        for(int i=0; i<C-1; i++) {
            map[0][i] = map[0][i+1];
        }
        for(int i=0; i<top; i++) {
            map[i][C-1] = map[i+1][C-1];
        }
        for(int i=C-1; i>1; i--) {
            map[top][i] = map[top][i-1];
        }
        map[top][1] = 0;

        // 공기청정기 아래쪽 작동
        for(int i=bottom+1; i<R-1; i++) {
            map[i][0] = map[i+1][0];
        }
        for(int i=0; i<C-1; i++) {
            map[R-1][i] = map[R-1][i+1];
        }
        for(int i=R-1; i>bottom; i--) {
            map[i][C-1] = map[i-1][C-1];
        }
        for(int i=C-1; i>1; i--) {
            map[bottom][i] = map[bottom][i-1];
        }
        map[bottom][1] = 0;
    }
}
