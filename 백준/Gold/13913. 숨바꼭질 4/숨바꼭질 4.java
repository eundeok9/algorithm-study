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

            for(int i=0; i<3; i++) {
                int next;
                
                if(i == 0) next = cur * 2;
                else if(i == 2) next = cur + 1;
                else next = cur - 1;
//            for(int i: new int[] {cur*2, cur-1, cur + 1}) { // 메모리 사용량 높을지도?
                if(next < 0 || next > 100000) continue;

                if(time[next] == 0) {
                    queue.add(next);
                    time[next] = time[cur] + 1;
                    parent[next] = cur;
                }
            }
        }

    }
}
