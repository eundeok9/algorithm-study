import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int INF = 100_000;

    static class Point implements Comparable<Point> {
        int x, y, rupee;

        Point(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        public int compareTo(Point o) {
            return this.rupee - o.rupee;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int index = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N==0) break;

            map = new int[N][N];
            dp = new int[N][N];

            for(int i=0; i<N; i++) {
                Arrays.fill(dp[i], INF);
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            sb.append("Problem ").append(index++).append(": ").append(dijkstra()).append("\n");
        }
        System.out.println(sb);
    }

    static int dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, map[0][0]));
        dp[0][0] = map[0][0];

        while(!pq.isEmpty()) {
            Point cur = pq.poll();

            if(dp[cur.x][cur.y] < cur.rupee) continue;
            if(cur.x == N-1 && cur.y == N-1) {
                return dp[N-1][N-1];
            }

            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(dp[nx][ny] > cur.rupee + map[nx][ny]) {
                    dp[nx][ny] = cur.rupee + map[nx][ny];
                    pq.offer(new Point(nx, ny, dp[nx][ny]));
                }
            }
        }

        return 0;
    }
}