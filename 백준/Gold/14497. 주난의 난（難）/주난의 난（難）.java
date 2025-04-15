import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int x1, y1, x2, y2;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        String s;
        char val;
        for(int i=0; i<N; i++) {
            s = br.readLine();
            for(int j=0; j<M; j++) {
                val = s.charAt(j);
                if(val == '#' || val == '*') continue;

                map[i][j] = val - '0';
            }
        }

        map[x2][y2] = 1;
        System.out.println(bfs(x1, y1));
    }

    public static int bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int curX = cur[0];
            int curY = cur[1];
            int time = cur[2];

            if(curX == x2 && curY == y2) {
                return time;
            }

            for(int d=0; d<4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if(check(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 1) {
                        queue.offerLast(new int[] {nx, ny, time + 1});
                    }
                    else {
                        queue.offerFirst(new int[] {nx, ny, time});
                    }
                }
            }

        }

        return -1;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}