import java.io.*;
import java.util.*;
public class Main {
    static int N, M, K;
    static int[] money;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        money = new int[N];
        visited = new boolean[N];
        graph = new ArrayList<>();

        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int sum = 0;
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                sum += bfs(i);
            }
            if(sum > K) {
                System.out.println("Oh no");
                return;
            }
        }

        System.out.println(sum);
    }

    public static int bfs(int start) {
        int min = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            min = Math.min(money[cur], min);

            for(int nxt: graph.get(cur)) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    queue.add(nxt);
                }
            }
        }

        return min;
    }
}