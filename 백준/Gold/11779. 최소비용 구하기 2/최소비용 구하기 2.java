import java.io.*;
import java.util.*;
public class Main {
    static final int INF = 1_000_000_000;
    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int t, int c) {
            this.to = t;
            this.cost = c;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        int[] route = new int[N+1]; // 직전에 방문한 노드 저장

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.to] < cur.cost) continue;
            if(cur.to == end) break;

            for(Node nxt: graph.get(cur.to)) {
                if(dist[nxt.to] > dist[cur.to] + nxt.cost) {
//                    System.out.println(cur.to + " " + nxt.to);
                    dist[nxt.to] = dist[cur.to] + nxt.cost;
                    pq.offer(new Node(nxt.to, dist[nxt.to]));
                    route[nxt.to] = cur.to;
                }
            }
        }

        System.out.println(dist[end]);

        ArrayList<Integer> routes = new ArrayList<>();
        int cur = end;
        while(cur != 0) {
            routes.add(cur);
            cur = route[cur];
        }

        System.out.println(routes.size());

        for(int i=routes.size()-1; i>=0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }
}