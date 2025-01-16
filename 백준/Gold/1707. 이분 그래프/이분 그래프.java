import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int[] color = new int[V];

            List<List<Integer>> graph = new ArrayList<>();
            for(int i=0; i<V; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean isBipartite = true;
            for(int i=0; i<V; i++) {
                if(color[i] == 0) {
                    if(!bfs(i, graph, color)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    static boolean bfs(int start, List<List<Integer>> graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int nxt: graph.get(cur)) {
                if(color[nxt] == 0) { // 색이 칠해지지 않았다면
                    color[nxt] = -color[cur]; // 반대 색으로 칠함
                    queue.add(nxt);
                } else if(color[nxt] == color[cur]) { // 같은 색이라면 이분 그래프가 아님
                    return false;
                }
            }
        }

        return true;
    }
}