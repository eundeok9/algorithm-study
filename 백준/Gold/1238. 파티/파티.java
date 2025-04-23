import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N+1];
        ArrayList<Node>[] revGraph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            revGraph[v].add(new Node(u, w));
        }

        int[] distFromX = dijkstra(graph, X, N);
        int[] distToX = dijkstra(revGraph, X, N);

        int answer = 0;
        for(int i=1; i<=N; i++) {
            answer = Math.max(answer, distFromX[i] + distToX[i]);
        }
        System.out.println(answer);
    }

    static int[] dijkstra(List<Node>[] graph, int start, int N) {
        final int INF = 1_000_000_000;
        int[] dist = new int[N+1];
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

        return dist;
    }
}