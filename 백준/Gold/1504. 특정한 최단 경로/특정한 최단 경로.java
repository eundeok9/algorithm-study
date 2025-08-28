import java.io.*;
import java.util.*;
public class Main {
    static final int INF = 1_000_000_000;
    static int N, M;
    static int[] dist;
    static List<List<Node>> graph;
    static class Node implements Comparable<Node> {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long a = dijkstra(1, v1);
        long b = dijkstra(v1, v2);
        long c = dijkstra(v2, N);

        long cost1 = (a >= INF || b >= INF || c>=INF) ? Long.MAX_VALUE: a+b+c;

        a = dijkstra(1, v2);
        b = dijkstra(v2, v1);
        c = dijkstra(v1, N);

        long cost2 = (a >= INF || b >= INF || c>=INF) ? Long.MAX_VALUE: a+b+c;

        long answer = Math.min(cost1, cost2);

        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.to] < cur.cost) continue;
            if(cur.to == end) break;

            for(Node nxt: graph.get(cur.to)) {
                if(dist[nxt.to] > dist[cur.to] + nxt.cost) {
                    dist[nxt.to] = dist[cur.to] + nxt.cost;
                    pq.offer(new Node(nxt.to, dist[nxt.to]));
                }
            }
        }

//        System.out.println(start + " " + end + " " + dist[end]);
        return dist[end];
    }
}
