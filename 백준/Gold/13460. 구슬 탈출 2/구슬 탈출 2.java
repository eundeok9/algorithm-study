import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, depth;
        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

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
                }
                if(board[i][j] == 'B') {
                    bx = i; by = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while(!queue.isEmpty()) {
            State cur = queue.poll();

            if(cur.depth >= 10) return -1;

            for(int d=0; d<4; d++) {
                MoveResult red = move(cur.rx, cur.ry, d);
                MoveResult blue = move(cur.bx, cur.by, d);

                if(board[blue.x][blue.y] == 'O') continue;
                if(board[red.x][red.y] == 'O') return cur.depth + 1;

                if(red.x == blue.x && red.y == blue.y) {
                    if(red.count > blue.count) {
                        red.x -= dx[d];
                        red.y -= dy[d];
                    } else {
                        blue.x -= dx[d];
                        blue.y -= dy[d];
                    }
                }

                if(!visited[red.x][red.y][blue.x][blue.y]) {
                    visited[red.x][red.y][blue.x][blue.y] = true;
                    queue.offer(new State(red.x, red.y, blue.x, blue.y, cur.depth + 1));
                }
            }
        }
        
        return -1;
    }

    static class MoveResult {
        int x, y, count;
        MoveResult(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static MoveResult move(int x, int y, int dir) {
        int count = 0;
        while(true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(board[nx][ny] == '#' || board[x][y] == 'O') break;

            x = nx;
            y = ny;
            count += 1;
        }

        return new MoveResult(x, y, count);
    }
}