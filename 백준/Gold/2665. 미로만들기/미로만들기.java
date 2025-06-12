import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node> {
        int x, y, cost;
        Node (int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        final int INF = N * N + 1;
        int[][] dist = new int[N][N];
        for(int [] row: dist) Arrays.fill(row, INF);

        dist[0][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, dist[0][0]));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost > dist[cur.x][cur.y]) continue;
            if(cur.x == N-1 && cur.y == N-1) break;

            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                int nextCost = cur.cost + (map[nx][ny] == 0 ? 1 : 0);
                if(nextCost < dist[nx][ny]) {
                    dist[nx][ny] = nextCost;
                    pq.offer(new Node(nx, ny, nextCost));
                }
            }
        }

        System.out.println(dist[N-1][N-1]);
    }
}
