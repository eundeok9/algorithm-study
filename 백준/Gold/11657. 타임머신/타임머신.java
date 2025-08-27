import java.io.*;
import java.util.*;
public class Main {
    static class Edge {
        int from, to, w;
        Edge(int f, int t, int w) {
            this.from = f;
            this.to = t;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 벨만-포드
        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        final long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for(int i=1; i<=N-1; i++) {
            boolean updated = false;
            for(Edge e: edges) {
                if(dist[e.from] == INF) continue;
                long nd = dist[e.from] + e.w;
                if(nd < dist[e.to]) {
                    dist[e.to] = nd;
                    updated = true;
                }
            }
            if(!updated) break;
        }

        // 음수 사이클 체크
        for(Edge e: edges) {
            if(dist[e.from] == INF) continue;
            if(dist[e.to] > dist[e.from] + e.w) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int v=2; v<=N; v++) {
            sb.append(dist[v] == INF ? -1 : dist[v]).append("\n");
        }
        System.out.println(sb);
    }
}