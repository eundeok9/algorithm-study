import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static class Node implements Comparable<Node> {
        int start, end, cost;
        Node(int s, int e, int c) {
            this.start = s;
            this.end = e;
            this.cost = c;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        parent = new int[N];
        List<Node> graph = new ArrayList<>();

        for(int i=0; i<N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(map[i][j] != 0) {
                    graph.add(new Node(i, j, map[i][j]));
                }
            }
        }

        Collections.sort(graph); // 비용 낮은 순으로 정렬
        int index = 0;
        long answer = 0;

        for(int i=0; i<graph.size(); i++) {
            if(index == N-1) break;

            Node node = graph.get(i);

            if(union(node.start, node.end)) {
                index++;
                answer += node.cost;
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
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find((parent[x]));
    }

}
