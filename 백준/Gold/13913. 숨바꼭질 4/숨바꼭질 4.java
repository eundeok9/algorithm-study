import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] time = new int[100001];
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while(index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time[K] - 1).append("\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == K) return;

            for(int i: new int[] {cur*2, cur-1, cur + 1}) {
                if(i < 0 || i > 100000) continue;

                if(time[i] == 0) {
                    queue.add(i);
                    time[i] = time[cur] + 1;
                    parent[i] = cur;
                }
            }
        }

    }
}
