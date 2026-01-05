import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0});
        map[0][0] = -1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == N-1 && cur[1] == M-1) {
                return cur[2];
            }

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(map[nx][ny] == 0) {
                    queue.addFirst(new int[] {nx, ny, cur[2]});
                } else if(map[nx][ny] == 1) {
                    queue.offer(new int[] {nx, ny, cur[2] + 1});
                }

                map[nx][ny] = -1; // 방문처리
            }
        }

        return -1;
    }
}