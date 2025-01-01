import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    static int[][] fire;
    static int[][] sanggeun;
    static Queue<int[]> fQueue; // 불
    static Queue<int[]> sQueue; // 상근이
    static int answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            fire = new int[N][M];
            sanggeun = new int[N][M];
            fQueue = new LinkedList<>();
            sQueue = new LinkedList<>();

            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<M; j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '#') {
                        fire[i][j] = -1;
                        sanggeun[i][j] = -1;
                    }
                    if(map[i][j] == '@') {
                        sanggeun[i][j] = 1;
                        sQueue.add(new int[] {i, j});
                    }
                    if(map[i][j] == '*') {
                        fire[i][j] = 1;
                        fQueue.add(new int[] {i, j});
                    }
                }
            }
            moveFire();

            answer = Integer.MAX_VALUE;
            bfs();
            sb.append(answer == Integer.MAX_VALUE ? "IMPOSSIBLE" : answer).append("\n");
        }
        System.out.println(sb);

    }

    public static void bfs() {
        while(!sQueue.isEmpty()) {
            int[] cur = sQueue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(check(nx, ny)) {
                    answer = sanggeun[x][y];
                    return;
                }
                if(sanggeun[nx][ny] != 0) continue;
                if(fire[nx][ny] != 0 && sanggeun[x][y] + 1 >= fire[nx][ny]) continue;
                sanggeun[nx][ny] = sanggeun[x][y] + 1;
                sQueue.add(new int[] {nx, ny});
            }
        }
    }

    public static void moveFire() {
        while(!fQueue.isEmpty()) {
            int[] cur = fQueue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(check(nx, ny)) continue;
                if(fire[nx][ny] != 0) continue;
                fire[nx][ny] = fire[x][y] + 1;
                fQueue.add(new int[] {nx, ny});
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= M;
    }
}
