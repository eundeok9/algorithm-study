import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] parent = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : graph.get(current)) {
                if(!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue.add(next);
                }
            }
        }

        for(int i=2; i<=N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}