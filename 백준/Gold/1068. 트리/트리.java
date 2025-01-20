import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static List<List<Integer>> graph;
    static int answer = 0;
    static boolean[] visited;
    static int delNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int root = -1;
        for(int i=0; i<N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1) {
                graph.get(parent).add(i);
            } else {
                root = i;
            }
        }

        visited = new boolean[N];
        delNode = Integer.parseInt(br.readLine());
        if(delNode != root) {
            dfs(root);
        }

        System.out.println(answer);
    }

    public static void dfs(int cur) {
        visited[cur] = true;

        boolean isLeaf = true;
        for(int nxt: graph.get(cur)) {
            if(!visited[nxt] && nxt != delNode) {
                isLeaf = false;
                visited[nxt] = true;
                dfs(nxt);
            }
        }

        if(isLeaf) {
            answer++;
        }
    }
}