import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node> {
        int to, dist;
        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    static int N, M, T;
    static int[] distS, distG, distH;
    static List<List<Node>> graph;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc  = Integer.parseInt(br.readLine());
        while(tc-->0) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
            }

            distS = dijkstra(S);
            distG = dijkstra(G);
            distH = dijkstra(H);
            
            List<Integer> result = new ArrayList<>();
            for(int i=0; i<T; i++) {
                int x = Integer.parseInt(br.readLine());
                int path1 = distS[G] + distG[H] + distH[x]; // (s -> g) + (g -> h) + (h -> x)
                int path2 = distS[H] + distH[G] + distG[x]; // (s->h) + (h->g) + (g->x)
                if(distS[x] == path1 || distS[x] == path2) result.add(x);
            }

            Collections.sort(result);
            for(int x: result) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.to] < cur.dist) continue;
            
            for(Node nxt: graph.get(cur.to)) {
                if(cur.dist + nxt.dist < dist[nxt.to]) {
                    dist[nxt.to] = cur.dist + nxt.dist;
                    pq.add(new Node(nxt.to, dist[nxt.to]));
                }
            }
        }

        return dist;
    }
}