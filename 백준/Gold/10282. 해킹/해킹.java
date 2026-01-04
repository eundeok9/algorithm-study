import java.io.*;
import java.util.*;
public class Main {
    static int n, d, c; // 컴퓨터 개수, 의존성 개수, 해킹당한 컴퓨터 번호
    static List<List<Computer>> graph;
    static int[] dist;
    static final int INF = 1_000_000_000;

    static class Computer {
        int num, dist; // 컴퓨터 번호, 감염되는데 걸리는 시간
        Computer(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    static class Node implements Comparable<Node> {
        int v, dist;
        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        // 더 빠른거부터
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    static int count = 0; // 감염되는 컴퓨터 수
    static int time = 0; // 걸리는 시간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            d = Integer.parseInt(st.nextToken()); // 의존성 개수
            c = Integer.parseInt(st.nextToken()); // 해킹 당한 컴퓨터 번호

            graph = new ArrayList<>();
            for(int i=0; i<=n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                // a가 b를 의존하며, b가 감영되면 s초 후 a도 감염됨
                // 단방향 + 가중치 O
                graph.get(b).add(new Computer(a, s));
            }

            dist = new int[n+1];
            Arrays.fill(dist, INF);

            dijkstra(c);
            sb.append(count).append(" ").append(time).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));

        dist[x] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.dist != dist[cur.v]) continue;

            for(Computer nxt: graph.get(cur.v)) {
                if(dist[nxt.num] > cur.dist + nxt.dist) {
                    dist[nxt.num] = cur.dist + nxt.dist;
                    pq.offer(new Node(nxt.num, dist[nxt.num]));
                }
            }
        }

        count = 0;
        time = 0;
        for(int i=1; i<=n; i++) {
            if(dist[i] != INF) {
                count++;
                time = Math.max(dist[i], time);
            }
        }
    }
}
