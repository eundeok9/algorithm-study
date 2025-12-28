import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'R') {
                    rx = i; ry = j;
                    board[i][j] = '.';
                } else if(board[i][j] == 'B') {
                    bx = i; by = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int d=0; d<4; d++) {
                MoveResult red = move(cur[0], cur[1], d);
                MoveResult blue = move(cur[2], cur[3], d);

                if(board[blue.x][blue.y] == 'O') continue;
                if(board[red.x][red.y] == 'O') return cur[4] + 1;

                if(red.x == blue.x && red.y == blue.y) {
                    if(red.cnt < blue.cnt) {
                        blue.x -= dx[d];
                        blue.y -= dy[d];
                    } else {
                        red.x -= dx[d];
                        red.y -= dy[d];
                    }
                }

                if(!visited[red.x][red.y][blue.x][blue.y]) {
                    visited[red.x][red.y][blue.x][blue.y] = true;
                    queue.offer(new int[]{red.x, red.y, blue.x, blue.y, cur[4]+1});
                }
            }

        }

        return -1;
    }

    static class MoveResult {
        int x, y, cnt;
        MoveResult(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static MoveResult move(int x, int y, int d) {
        int count = 0;
        while(true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(board[nx][ny] == '#' || board[x][y] == 'O') break;

            x = nx;
            y = ny;
            count++;
        }

        return new MoveResult(x, y, count);
    }
}
