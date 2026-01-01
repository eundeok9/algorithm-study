import java.io.*;
import java.util.*;

public class Main {
    static int n, d, c;
    static List<List<Dependency>> graph;

    static class Dependency {
        int computer, time;
        Dependency(int computer, int time) {
            this.computer = computer;
            this.time = time;
        }
    }

    static class Node implements Comparable<Node> {
        int v, dist;
        Node(int v, int dist) { this.v = v; this.dist = dist; }
        public int compareTo(Node o) { return Integer.compare(this.dist, o.dist); }
    }

    static int count;
    static int time;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Dependency(a, s)); // b -> a (s초)
            }

            dijkstra();
            sb.append(count).append(" ").append(time).append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra() {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[c] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(c, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist != dist[cur.v]) continue; // 구버전 스킵

            for (Dependency nxt : graph.get(cur.v)) {
                int nd = cur.dist + nxt.time;
                if (nd < dist[nxt.computer]) {
                    dist[nxt.computer] = nd;
                    pq.offer(new Node(nxt.computer, nd));
                }
            }
        }

        count = 0;
        time = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != INF) {
                count++;
                time = Math.max(time, dist[i]);
            }
        }
    }
}
