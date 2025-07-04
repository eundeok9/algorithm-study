import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
            int num = Integer.parseInt(st.nextToken());
            int[] singers = new int[num];
            for(int n=0; n<num; n++) {
                singers[n] = Integer.parseInt(st.nextToken());
            }
            for(int n=0; n<num-1; n++) {
                int a = singers[n];
                int b = singers[n+1];
                graph.get(a).add(b);
                inDegree[b]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }
        
        int count = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append("\n");
            count++;
            for(int nxt: graph.get(cur)) {
                if(--inDegree[nxt] == 0) {
                    queue.offer(nxt);
                }
            }
        }
        
        if(count < N) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }
}