import java.io.*;
import java.util.*;
public class Main {
    static class Computer implements Comparable<Computer> {
        int d;
        int t;

        Computer(int d, int t) {
            this.d = d;
            this.t = t;
        }

        public int compareTo(Computer o) {
            return this.t - o.t;
        }
    }

    static int INF = Integer.MAX_VALUE;

    static List<List<Computer>> graph;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            dist = new int[N+1];
            visited = new boolean[N+1];

            for(int i=0; i<=N; i++) {
                graph.add(new ArrayList<>());
                dist[i] = INF;
            }

            for(int i=0; i<D; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Computer(a, s));
            }

            dijkstra(C);

            int cnt = 0;
            int time = 0;

            for(int i=1; i<=N; i++) {
                if(dist[i] != INF) {
                    cnt++;
                    time = Math.max(time, dist[i]);
                }
            }
            
            sb.append(cnt).append(" ").append(time).append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Computer(start, 0));

        while(!pq.isEmpty()) {
            int cur = pq.poll().d;

            if(!visited[cur]) {
                visited[cur] = true;

                for(Computer nxt: graph.get(cur)) {
                    if(dist[nxt.d] > dist[cur] + nxt.t) {
                        dist[nxt.d] = dist[cur] + nxt.t;
                        pq.offer(new Computer(nxt.d, dist[nxt.d]));
                    }
                }
            }
        }
    }
}
