import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node> {
        int from, to; double length;
        Node(int from, int to, double length) {
            this.from = from;
            this.to = to;
            this.length = length;
        }

        public int compareTo(Node o) {
            return Double.compare(this.length, o.length);
        }
    }

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] position = new int[N+1][2]; // i번 우주신의 좌표
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            position[i][0] = x;
            position[i][1] = y;
        }

        parent = new int[N+1];
        for(int i=0; i<=N; i++) parent[i] = i;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        List<Node> list = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            int x1 = position[i][0];
            int y1 = position[i][1];
            for(int j=i+1; j<=N; j++) {
                if(find(i) == find(j)) continue;

                int x2 = position[j][0];
                int y2 = position[j][1];

                double dist = getDist(x1, x2, y1, y2);

                list.add(new Node(i, j, dist));
            }
        }

        Collections.sort(list);

        double answer = 0;

        for(int i=0; i<list.size(); i++) {

            Node node = list.get(i);

            if(union(node.from, node.to)) {
                answer += node.length;
            }
        }

        System.out.printf("%.2f", answer);
    }

    static double getDist(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) {
            return false;
        }

        parent[rootB] = rootA;
        return true;
    }

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}