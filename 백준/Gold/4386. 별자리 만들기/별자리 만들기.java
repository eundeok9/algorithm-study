import java.io.*;
import java.util.*;
public class Main {
    static class Star {
        double x, y;
        Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;
        Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Star[] stars = new Star[N];
        parent = new int[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars[i] = new Star(x, y);
        }

        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                double dist = getDistance(stars[i], stars[j]);
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);

        for(int i=0; i<N; i++) {
            parent[i] = i;
        }

        double result = 0;
        int count = 0;
        for(Edge edge: edges) {
            if(union(edge.from, edge.to)) {
                result += edge.weight;
                count++;
                if(count == N-1) break; // MST 완성
            }
        }

        System.out.printf("%.2f\n", result);

    }

    static double getDistance(Star a, Star b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

    static int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
