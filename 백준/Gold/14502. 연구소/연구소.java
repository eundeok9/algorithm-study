import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] board;
    static int[] selected;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new int[3];
        backTracking(0);
        System.out.println(answer);
    }

    static void backTracking(int depth) {
        if(depth == 3) {
            virus();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    backTracking(depth + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    static void virus() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] tmpMap = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmpMap[i][j] = board[i][j];
                if(tmpMap[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(tmpMap[nx][ny] == 0) {
                    tmpMap[nx][ny] = 2;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tmpMap[i][j] == 0) {
                    count++;
                }
            }
        }

        answer = Math.max(count, answer);
    }
}