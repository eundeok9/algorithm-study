import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int a, b, c;
    static int[][] map;
    static int endX = -1, endY = -1; // 무등산 정상
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
            return this.cost - o.cost;
        }
    }

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int maxHeight = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(maxHeight < map[i][j]) {
                    endX = i;
                    endY = j;
                    maxHeight = map[i][j];
                }
            }
        }

        dijkstra(startX, startY);

        System.out.println(answer);
    }

    static void dijkstra(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, y, 0));

        int[][] dist = new int[N][M];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[x][y] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == endX && cur.y == endY) {
                answer = cur.cost;
                return;
            }

            if (cur.cost > dist[cur.x][cur.y]) continue; // 이미 더 짧은 경로가 있으면 skip

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (Math.abs(map[cur.x][cur.y] - map[nx][ny]) > c) continue;

                int diff = map[cur.x][cur.y] - map[nx][ny];
                int nextCost = cur.cost;
                if (diff == 0) nextCost += 1;
                else if (diff < 0) nextCost += -diff * a;
                else nextCost += diff * b;

                if (nextCost < dist[nx][ny]) {
                    dist[nx][ny] = nextCost;
                    pq.offer(new Node(nx, ny, nextCost));
                }
            }
        }
    }

}

// 높이 차이 안나면 이동 시 -> 1분 소요
// 높은 곳으로 이동 시 -> 차이 * a분 소요
// 낮은 곳으로 이동 시 -> 차이 * b분 소요
// 높이 차이가 c보다 크면 이동 불가

// 무등산 정상 -> 높이가 가장 높은 곳
// (x,y)에서 정상까지 도달하기 위한 최소시간