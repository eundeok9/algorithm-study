import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N+1];
            int answer = 0;
            for(int i=1; i<=N; i++) {
                if(!visited[i]) {
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i);
                    visited[i] = true;

                    while(!queue.isEmpty()) {
                        int cur = queue.poll();
                        int nxt = arr[cur];

                        if(visited[nxt]) { // 사이클 발생
                            answer++;
                            break;
                        }

                        queue.add(nxt);
                        visited[nxt] = true;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}