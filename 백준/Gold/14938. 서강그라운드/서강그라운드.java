import java.io.*;
import java.util.*;
public class Main {
    static int N, M, R;
    static int[] items;
    static List<List<Edge>> graph;
    static int[] dist;
    static boolean[] check;
    static class Edge implements Comparable<Edge> {
        int to, dist;
        Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, l));
            graph.get(b).add(new Edge(a, l));
        }

        dist = new int[N+1];
        check = new boolean[N+1];

        int answer = 0;
        for(int i=1; i<=N; i++) {
            // 각 점에서 얻을 수 있는 아이템 수
            answer = Math.max(answer, dijkstra(i));
        }
        System.out.println(answer);
    }

    public static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(check, false);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(!check[cur.to]) {
                check[cur.to] = true;

                for(Edge nxt: graph.get(cur.to)) {
                    if(!check[nxt.to] && dist[nxt.to] > dist[cur.to] + nxt.dist) {
                        dist[nxt.to] = dist[cur.to] + nxt.dist;
                        pq.offer(new Edge(nxt.to, dist[nxt.to]));
                    }
                }
            }
        }

        int result = 0;
        for(int i=1; i<=N; i++) {
            if(dist[i] <= M) {
                result += items[i];
            }
        }

        return result;
    }
}