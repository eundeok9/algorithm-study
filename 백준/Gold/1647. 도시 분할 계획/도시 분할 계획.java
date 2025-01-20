import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();
    static class Edge implements Comparable<Edge> {
        int a, b, cost;

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, cost));
        }

        Collections.sort(edges);

        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        int totalCost = 0; // MST 총 비용
        int maxCost = 0; // MST에서 가장 큰 간선 비용

        for(Edge edge: edges) {
            if(union(edge.a, edge.b)) {
                totalCost += edge.cost;
                maxCost = edge.cost;
            }
        }

        System.out.println(totalCost - maxCost);
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }

        return false;
    }
}