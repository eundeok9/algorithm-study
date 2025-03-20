import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<List<Integer>> graph;
    static int[] result;   // 각 노드에서 해킹 가능한 컴퓨터 수
    static int[] visited;  // 방문 여부를 체크할 배열 (방문 아이디 사용)
    static int visitId = 0; // BFS마다 증가시키는 방문 아이디

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // b -> a (역방향 간선)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(b).add(a);
        }

        result = new int[N];
        visited = new int[N]; // 모든 원소는 초기값 0

        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = bfs(i);
            result[i] = count;
            if(count > max) {
                max = count;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(result[i] == max) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static int bfs(int start) {
        visitId++;  // 매 BFS마다 방문 아이디 증가
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = visitId;
        int cnt = 0;  // 시작 노드는 제외하고 카운트

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (visited[next] != visitId) {
                    visited[next] = visitId;
                    queue.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
