import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static HashMap<Integer, Integer> ladder = new HashMap<>();
    static HashMap<Integer, Integer> snake = new HashMap<>();
    static int[] visited = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ladder.put(from, to);
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            snake.put(from, to);
        }

        bfs();

        System.out.println(visited[100] - 1);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == 100) {
                return;
            }

            for(int i=1; i<=6; i++) {
                int next = cur + i;
                if(next > 100) continue;
                if(visited[next] != 0) continue;
                if(ladder.containsKey(next)) {
                    visited[next] = visited[cur] + 1;
                    next = ladder.get(next);
                }
                if(snake.containsKey(next)) {
                    visited[next] = visited[cur] + 1;
                    next = snake.get(next);
                }
                if(visited[next] != 0) continue;
                queue.add(next);
                visited[next] = visited[cur] + 1;
            }
        }
    }
}
