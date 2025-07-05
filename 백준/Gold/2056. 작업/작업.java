import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] times = new int[N];
        List<List<Integer>> graph = new ArrayList<>();
        int[] dp = new int[N];
        int[] inDegree = new int[N];

        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            int count = Integer.parseInt(st.nextToken());
            for(int c=0; c<count; c++) {
                int num = Integer.parseInt(st.nextToken())-1;
                graph.get(num).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
                dp[i] = times[i]; // 선행 작업이 없는 경우, 자기 시간 그대로
            }
        }


        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int nxt: graph.get(cur)) {
                dp[nxt] = Math.max(dp[nxt], dp[cur] + times[nxt]);
                if(--inDegree[nxt] == 0) {
                    queue.offer(nxt);
                }
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}