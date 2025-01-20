import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;
    public static class Edge implements Comparable<Edge> {
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

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<E;i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, cost));
        }

        Collections.sort(edges);

        parent = new int[V+1];
        for(int i=1; i<=V; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgeCount = 0;
        for(Edge edge: edges) {
            if(union(edge.a, edge.b)) {
                totalCost += edge.cost;
                edgeCount++;

                if(edgeCount == V-1) {
                    break;
                }
            }
        }

        System.out.println(totalCost);
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        
        return false;
    }
}