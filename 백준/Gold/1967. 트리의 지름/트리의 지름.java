import java.io.*;
import java.util.*;
public class Main {
    static List<Edge>[] tree;
    static boolean[] visited;
    static int farNode;
    static int answer;

    static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[u].add(new Edge(v, w));
            tree[v].add(new Edge(u, w));
        }

        // 임의의 노드에서 가장 먼 노드 찾기
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1, 0);


        // farNode에서 dfs 실행해서 트리의 지름 구하기
        visited = new boolean[N+1];
        visited[farNode] = true;
        dfs(farNode, 0);

        System.out.println(answer);

    }

    public static void dfs(int node, int distance) {
        answer = Math.max(distance, answer);
        if(distance == answer) {
            farNode = node;
        }

        for(Edge edge: tree[node]) {
            if(!visited[edge.to]) {
                visited[edge.to] = true;
                dfs(edge.to, distance + edge.weight);
            }
        }
    }
}