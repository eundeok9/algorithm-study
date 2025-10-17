import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = 1_000_000_000;
    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        // 비용 적은 순 (오름차순)
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

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

            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] friends = new int[K];
            for(int i=0; i<K; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }

            int[][] allDist = new int[K][N+1];
            for(int i=0; i<K; i++) {
                dist = new int[N+1];
                Arrays.fill(dist,INF);
                dijkstra(friends[i]);
                for(int j=1; j<=N; j++) {
                    allDist[i][j] = dist[j];
                }
            }

            int minPoint = -1;
            int minDist = INF;
            for(int to=1; to<=N; to++) {
                int sum = 0;
                for(int i=0; i<K; i++) {
                    sum += allDist[i][to];
                }
                if(sum < minDist) {
                    minDist = sum;
                    minPoint = to;
                }
            }

            sb.append(minPoint).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.to] < cur.cost) continue;

            for(Node next: graph.get(cur.to)) {
                if(dist[next.to] > cur.cost + next.cost) {
                    dist[next.to] = cur.cost + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}