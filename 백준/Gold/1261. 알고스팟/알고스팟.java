import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == N-1 && cur[1] == M-1) {
                return cur[2];
            }

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(0<=nx && nx<N && 0<=ny && ny<M) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if(map[nx][ny] == 0) {
                            queue.offerFirst(new int[] {nx, ny, cur[2]});
                        } else {
                            queue.offerLast(new int[] {nx, ny, cur[2] + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }
}