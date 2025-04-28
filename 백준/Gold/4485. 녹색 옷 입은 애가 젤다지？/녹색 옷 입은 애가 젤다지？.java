import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Node implements Comparable<Node> {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }


        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0) {
                System.out.println(sb);
                return;
            }

            map = new int[N][N];
            dist = new int[N][N];

            final int INF = 1_000_000_000;

            for(int i=0; i<N; i++) {
                Arrays.fill(dist[i], INF);
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist[0][0] = map[0][0];
            dijkstra();

            sb.append("Problem ").append(index).append(": ").append(dist[N-1][N-1]).append("\n");
            index++;
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, dist[0][0]));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;

            if(x == N-1 && y == N-1) return;
            
            if(cost > dist[x][y]) continue;
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
                
                if(dist[nx][ny] > cost + map[nx][ny]) {
                    dist[nx][ny] = cost + map[nx][ny];
                    pq.add(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }
    }
}