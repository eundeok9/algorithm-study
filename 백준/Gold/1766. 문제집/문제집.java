import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++) {
            if(inDegree[i] == 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");
            for(int nxt: graph.get(cur)) {
                if(--inDegree[nxt] == 0) pq.offer(nxt);
            }
        }

        System.out.println(sb);
    }
}
