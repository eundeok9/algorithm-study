import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int[][] visited;
    static class Node implements Comparable<Node> {
        int x, y, rupee;
        Node(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        public int compareTo(Node o) {
            return this.rupee - o.rupee;
        }
    }
    static int N;
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            map = new int[N][N];
            visited = new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Arrays.fill(visited[i], INF);
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();

            sb.append("Problem ").append(tc++).append(": ").append(visited[N-1][N-1]).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, map[0][0]));
        visited[0][0] = map[0][0];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.x == N-1 && cur.y == N-1) return;

            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if(visited[nx][ny] > visited[cur.x][cur.y] + map[nx][ny]) {
                    visited[nx][ny] = visited[cur.x][cur.y] + map[nx][ny];
                    pq.offer(new Node(nx, ny, visited[nx][ny]));
                }
            }
        }
    }
}
