import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[1000001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == K) {
                System.out.println(visited[K] - 1);
                return;
            }
            for(int i: new int[] {cur * 2, cur - 1, cur + 1}) {
                if(0 <= i && i <= 100000 && visited[i] == 0) {
                    if (i != cur * 2) {
                        visited[i] = visited[cur] + 1;
                        queue.add(i);
                    } else {
                        visited[i] = visited[cur];
                        queue.add(i);
                    }
                }
            }
        }
    }
}
