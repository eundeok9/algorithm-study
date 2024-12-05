import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static Queue<int[]> queue;

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        init();
        if(N-1 == 0 && M-1 == 0) {
            System.out.println(1);
            return;
        }
        queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0});
        bfs();
        System.out.println(answer);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
    }

    public static void bfs() {
        // 0 n m : 벽 안부숨
        // 1 n m : 벽 부숨
        // check[][][] == 1 : 방문함
        // check[][][] == 0 : 방문하지 않음
        int[][][] check = new int[2][N][M];
        check[0][0][0] = 1;
        while(!queue.isEmpty()) {
            int [] cur = queue.poll();
            int flag = cur[0];
            int x = cur[1];
            int y = cur[2];
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(check(nx, ny)) continue;
                if(map[nx][ny] == 0) {
                    if(check[flag][nx][ny] == 0) {
                        queue.add(new int[] {flag, nx, ny});
                        check[flag][nx][ny] = check[flag][x][y] + 1;
                        if(nx == N-1 && ny == M-1) {
                            answer = check[flag][nx][ny];
                            return;
                        }
                    }
                } else {
                    if(flag == 0) {
                        if(check[1][nx][ny] == 0) {
                            queue.add(new int[] {1, nx, ny});
                            check[1][nx][ny] = check[0][x][y] + 1;
                            if (nx == N-1 && ny == M-1) {
                                answer = check[1][nx][ny];
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= M;
    }
}
