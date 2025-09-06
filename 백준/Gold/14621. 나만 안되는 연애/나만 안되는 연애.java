import java.io.*;
import java.util.*;
public class Main {
    static int[] parents;
    static class Node implements Comparable<Node> {
        int from, to, dist;
        Node(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] univ = new char[N+1];
        for(int i=1; i<=N; i++) univ[i] = st.nextToken().charAt(0);

        List<Node> list = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Node(u, v, d));
        }

        Collections.sort(list);

        parents = new int[N+1];
        for(int i=0; i<=N; i++) {
            parents[i] = i;
        }

        int answer = 0;
        int index = 0;
        for(Node node: list) {
            int from = node.from;
            int to = node.to;
            if((univ[from] != univ[to]) && union(from, to)) {
                answer += node.dist;
                index++;
            }
        }

        System.out.println(index != N-1 ? -1 : answer);
    }

    static int find(int x) {
        if(parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;

        parents[rootB] = rootA;
        return true;
    }
}