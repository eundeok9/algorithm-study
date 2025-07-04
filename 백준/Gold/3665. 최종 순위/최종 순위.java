import java.io.*;
import java.util.*;
public class Main {
    static int T, N, M;
    static int[] inDegree;
    static boolean[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-->0) {
            N = Integer.parseInt(br.readLine());
            inDegree = new int[N+1];
            graph = new boolean[N+1][N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] lastYear = new int[N+1];
            for(int i=1; i<=N; i++) {
                lastYear[i] = Integer.parseInt(st.nextToken());
            }

            // 작년 순위 기준 그래프 구성
            for(int i=1; i<=N; i++) {
                for(int j=i+1; j<=N; j++) {
                    int higher = lastYear[i];
                    int lower = lastYear[j];
                    graph[higher][lower] = true;
                    inDegree[lower]++;
                }
            }

            // 순위 변경 처리
            M = Integer.parseInt(br.readLine());
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 방향 뒤집기
                if(graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    inDegree[b]--;
                    inDegree[a]++;
                } else {
                    graph[b][a] = false;
                    graph[a][b] = true;
                    inDegree[a]--;
                    inDegree[b]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i=1; i<=N; i++) {
                if(inDegree[i] == 0) queue.offer(i);
            }

            List<Integer> result = new ArrayList<>();
            boolean certain = true;
            boolean cycle = false;

            for(int i=0; i<N; i++) {
                // 진입차수가 0인 노드가 없는데 아직 출력 안한 팀이 있음 -> 사이클 발생함: 순위 확정 불가
                if(queue.isEmpty()) {
                    cycle = true;
                    break;
                }

                // 진입 차수가 0인 팀이 여러명 -> 가능한 순위가 여러가지임
                if(queue.size() > 1) {
                    certain = false;
                }

                int cur = queue.poll();
                result.add(cur);
                for(int j=1; j<=N; j++) {
                    if(graph[cur][j]) {
                        inDegree[j]--;
                        if(inDegree[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
            }

            if(cycle) {
                sb.append("IMPOSSIBLE\n");
            } else if(!certain) {
                sb.append("?\n");
            } else {
                for(int team: result) {
                    sb.append(team).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
