import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N];
            int[] inDegree = new int[N];
            boolean[][] graph = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    int high = rank[i] - 1;
                    int low = rank[j] - 1;
                    graph[high][low] = true;
                    inDegree[low]++;
                }
            }

            int M = Integer.parseInt(br.readLine());
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                if(graph[a][b]) {
                    graph[a][b] = false;
                    inDegree[b]--;
                    graph[b][a] = true;
                    inDegree[a]++;
                } else {
                    graph[b][a] = false;
                    inDegree[a]--;
                    graph[a][b] = true;
                    inDegree[b]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<N; i++) {
                if(inDegree[i]==0) {
                    queue.offer(i);
                }
            }

            List<Integer> result = new ArrayList<>();
            boolean cycle = false;
            boolean certain = true;
            for(int i=0; i<N; i++) {
                if(queue.isEmpty()) {
                    cycle = true;
                    break;
                }

                if(queue.size() > 1) {
                    certain = false;
                    break;
                }

                int cur = queue.poll();
                result.add(cur+1);
                for(int j=0; j<N; j++) {
                    if(graph[cur][j]) {
                        if(--inDegree[j] == 0) {
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
                for(int num: result) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}