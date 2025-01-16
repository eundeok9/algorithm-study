import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> graph;
    static int delNode;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        int root = -1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1) {
                graph.get(parent).add(i);
            } else {
                root = i;
            }
        }

        delNode = Integer.parseInt(br.readLine());
        if(delNode != root) {
            dfs(root);
        }

        System.out.println(answer);
    }

    public static void dfs(int current) {
        if(current == delNode) {
            return; // 삭제된 노드는 탐색X
        }

        boolean isLeaf = true;
        for(int child: graph.get(current)) {
            if(child != delNode) {
                isLeaf = false;
                dfs(child);
            }
        }

        if(isLeaf) {
            answer++;
        }
    }
}