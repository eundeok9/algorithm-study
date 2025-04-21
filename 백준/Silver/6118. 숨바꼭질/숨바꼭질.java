import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static List<Integer> list;
    static int maxDist = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[N];
        bfs();

        Collections.sort(list);
        System.out.println(list.get(0)+1 + " " + maxDist + " " + list.size());

    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>(); // 헛간 번호, 거리
        queue.add(new int[] {0, 0}); // 1번 헛간에서 출발
        visited[0] = true;

        list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[1] > maxDist && cur[0] != 0) {
                maxDist = cur[1];
                list.clear();
                list.add(cur[0]);
            } else if(maxDist == cur[1]) {
                list.add(cur[0]);
            }

            for(int nxt: graph.get(cur[0])) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    queue.add(new int[] {nxt, cur[1] + 1});
                }
            }
        }
    }
}