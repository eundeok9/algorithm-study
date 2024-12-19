import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] board;
    static int[] kLocation = new int[2];

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];

        int d = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        board[0][0] = N*N;
        for(int i=N*N - 1; i>0; i--) {
            int[] cur = queue.poll();
            int nx = cur[0] + dx[d];
            int ny = cur[1] + dy[d];

            if(check(nx, ny) || board[nx][ny] != 0) {
                nx -= dx[d];
                ny -= dy[d];
                d = (d+1) % 4;
                nx += dx[d];
                ny += dy[d];
            }
            if(i==K) {
                kLocation[0] = nx;
                kLocation[1] = ny;
            }
            board[nx][ny] = i;
            queue.add(new int[] {nx, ny});
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(kLocation[0] + 1).append(" ").append(kLocation[1] + 1);
        System.out.println(sb);
    }

    public static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= N;
    }
}
