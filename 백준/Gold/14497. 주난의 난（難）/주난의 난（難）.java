import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken())-1;
        int y1 = Integer.parseInt(st.nextToken())-1;
        int x2 = Integer.parseInt(st.nextToken())-1;
        int y2 = Integer.parseInt(st.nextToken())-1;

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                if(s.charAt(j) == '*') {
                    map[i][j] = 0;
                } else if(s.charAt(j) == '#') {
                    map[i][j] = 1;
                }else {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
        }

        dijkstra(x1, x2, y1, y2);
    }

    static void dijkstra(int x1, int x2, int y1, int y2) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x1, y1});

        dist = new int[N][M];
        for(int i=0; i<N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[x1][y1] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == x2 && cur[1] == y2) {
                System.out.println(dist[x2][y2]);
                return;
            }

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(dist[cur[0]][cur[1]] + map[nx][ny] < dist[nx][ny]) {
                    dist[nx][ny] = dist[cur[0]][cur[1]] + map[nx][ny];

                    if(map[nx][ny] == 0) {
                        queue.addFirst(new int[] {nx, ny});
                    } else {
                        queue.addLast(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
