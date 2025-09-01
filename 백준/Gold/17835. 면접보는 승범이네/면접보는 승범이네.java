import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static long[] dp;
    static List<List<Node>> graph;
    static HashSet<Integer> locationList;

    static long maxDist = -1;
    static long maxLocation = -1;
    static final long INF = 1_000_000_000_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(v).add(new Node(u, c)); // 단방향
        }

        locationList = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            locationList.add(Integer.parseInt(st.nextToken()));
        }

        dp = new long[N+1];
        Arrays.fill(dp, INF);
        dijkstra();

        for(int i=1; i<=N; i++) {
            if(dp[i] > maxDist) {
                maxDist = dp[i];
                maxLocation = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLocation).append("\n").append(maxDist);
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i=1; i<=N; i++) {
            if(locationList.contains(i)) {
                dp[i] = 0;
                pq.offer(new Node(i, 0));
            }
        }

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost > dp[cur.to]) continue;

            for(Node nxt: graph.get(cur.to)) {
                long nd = dp[cur.to] + nxt.cost;
                if(dp[nxt.to] > nd) {
                    dp[nxt.to] = nd;
                    pq.offer(new Node(nxt.to, nd));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to; long cost;
        Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}