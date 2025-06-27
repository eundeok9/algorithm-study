import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[1_000_001];
        visited[A] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(A);
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == K) {
                System.out.println(visited[cur] - 1);
                break;
            }

            for(int nxt: new int[] {cur*2, cur+1}) {
                if(nxt > 1_000_000) continue;
                if(visited[nxt] != 0) continue;
                visited[nxt] = visited[cur] + 1;
                queue.offer(nxt);
            }
        }
    }
}