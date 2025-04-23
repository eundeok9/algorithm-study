import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {this.v = v; this.w = w;}

        public int compareTo( Node o) {
            return w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        final int INF = 1_000_000_000;
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.w > dist[cur.v]) continue;
            for(Node nxt: graph[cur.v]) {
                if(dist[nxt.v] > cur.w + nxt.w) {
                    dist[nxt.v] = cur.w + nxt.w;
                    pq.add(new Node(nxt.v, dist[nxt.v]));
                }
            }
        }

        for(int i=1; i<=V; i++) {
            System.out.println(dist[i] != INF ? dist[i] : "INF");
        }
    }
}