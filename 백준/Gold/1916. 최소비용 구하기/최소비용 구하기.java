import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<List<Bus>> graph;
    static int start, end;
    static class Bus implements Comparable<Bus> {
        int v, dist;

        Bus(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        public int compareTo(Bus o) {
            return this.dist - o.dist;
        }
    }
    static int[] dist;
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Bus(b, dist));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, INF);

        dijkstra();

        System.out.println(dist[end]);
    }

    static void dijkstra() {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));

        dist[start] = 0;

        while(!pq.isEmpty()) {
            Bus cur = pq.poll();

            if(cur.v == end) return;
            if(cur.dist > dist[cur.v]) continue;

            for(Bus nxt: graph.get(cur.v)) {
                int nd = dist[cur.v] + nxt.dist;
                if(dist[nxt.v] > nd) {
                    dist[nxt.v] = nd;
                    pq.offer(new Bus(nxt.v, nd));
                }
            }
        }
    }
}