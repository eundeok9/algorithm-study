import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = 1_000_000_001;
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
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, INF));
        dist[start] = INF;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.to == end) break;
            if(dist[cur.to] > cur.weight) continue;

            for(Node nxt: graph.get(cur.to)) {
                int minWeight = Math.min(cur.weight, nxt.weight);
                if(minWeight > dist[nxt.to]) {
                    dist[nxt.to] = minWeight;
                    pq.offer(new Node(nxt.to, minWeight));
                }
            }
        }

        System.out.println(dist[end]);
    }

    static class Node implements Comparable<Node> {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }
}