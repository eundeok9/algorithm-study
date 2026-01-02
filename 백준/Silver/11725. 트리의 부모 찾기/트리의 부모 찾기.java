import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        parent = new int[N+1];
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1);
        
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
    
    static void dfs(int cur) {
        for(int nxt: graph.get(cur)) {
            if(!visited[nxt]) {
                visited[nxt] = true;
                parent[nxt] = cur;
                dfs(nxt);
            }
        }
    }
}
