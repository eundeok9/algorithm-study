import java.io.*;
import java.util.*;
public class Main {
    static class Planet {
        int idx, x, y, z;
        Planet(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        int dist;
        Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Planet[] planets = new Planet[N];
        parent = new int[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>();

        Arrays.sort(planets, (p1, p2) -> p1.x - p2.x);
        for(int i=0; i<N-1; i++) {
            int weight = Math.abs(planets[i].x - planets[i+1].x);
            edges.add(new Edge(planets[i].idx, planets[i+1].idx, weight));
        }

        Arrays.sort(planets, (p1, p2) -> p1.y - p2.y);
        for(int i=0; i<N-1; i++) {
            int weight = Math.abs(planets[i].y - planets[i+1].y);
            edges.add(new Edge(planets[i].idx, planets[i+1].idx, weight));
        }

        Arrays.sort(planets, (p1, p2) -> p1.z - p2.z);
        for(int i=0; i<N-1; i++) {
            int weight = Math.abs(planets[i].z - planets[i+1].z);
            edges.add(new Edge(planets[i].idx, planets[i+1].idx, weight));
        }

        Collections.sort(edges);

        int answer = 0;
        int count = 0;
        for(Edge edge: edges) {
            if(union(edge.from, edge.to)) {
                answer += edge.dist;
                count++;
                if(count == N-1) break;
            }
        }

        System.out.println(answer);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}