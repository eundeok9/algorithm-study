import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node> {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        int[] dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        // 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(cur.cost > dist[cur.to]) continue;
            if(cur.to == end) break;

            for(Node nxt: graph.get(cur.to)) {
                if(dist[nxt.to] > dist[cur.to] + nxt.cost) {
                    // visited[nxt.to] = true;
                    dist[nxt.to] = dist[cur.to] + nxt.cost;
                    pq.offer(new Node(nxt.to, dist[nxt.to]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
