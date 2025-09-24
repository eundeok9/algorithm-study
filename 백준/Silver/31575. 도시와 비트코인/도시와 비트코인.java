import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int N, M;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs() ? "Yes" : "No");
    }

    static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == N-1 && cur[1] == M-1) {
                return true;
            }

            for(int d=0; d<2; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }

        return false;
    }
}