import java.io.*;
import java.util.*;
public class Main {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken()); // 집의 수
            int N = Integer.parseInt(st.nextToken()); // 길의 수

            if(N==0 && M==0) {
                break;
            }

            List<List<Edge>> graph = new ArrayList<>();
            for(int i=0; i<M; i++) {
                graph.add(new ArrayList<>());
            }

            int total = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Edge(b, dist));
                graph.get(b).add(new Edge(a, dist));

                total += dist; // 전체 비용 누적
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[M];
            pq.offer(new Edge(0, 0));

            int cost = 0;
            while(!pq.isEmpty()) {
                Edge cur = pq.poll();

                if(visited[cur.to]) continue;

                visited[cur.to] = true;
                cost += cur.dist;

                for(Edge nxt: graph.get(cur.to)) {
                    if(!visited[nxt.to]) {
                        pq.offer(nxt);
                    }
                }
            }
            sb.append(total - cost).append("\n");
        }
        System.out.println(sb);
    }
}