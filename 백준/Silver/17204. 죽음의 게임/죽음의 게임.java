import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == K) {
                System.out.println(cur[1]);
                return;
            }
            if(!visited[arr[cur[0]]]) {
                visited[arr[cur[0]]] = true;
                queue.add(new int[] {arr[cur[0]], cur[1] + 1});
            }
        }

        System.out.println(-1);
    }
}