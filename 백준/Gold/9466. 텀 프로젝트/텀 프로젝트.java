import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static boolean[] visited;
    static boolean[] done;
    static int count; // 완성된 인원 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            count = 0;
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[N];
            visited = new boolean[N];
            done = new boolean[N];
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1; // 0-based
            }

            for(int i=0; i<N; i++) {
                if(!done[i]) { // dfs를 시행하는 조건이 있을거고.. 예를 들어 아직 팀이 결성 되지 않은 학생일 경우..
                    dfs(i);
                }
            }

            sb.append(N-count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        if(visited[node]) {
            done[node] = true;
            count++;
        } else {
            visited[node] = true;
        }

        if(!done[arr[node]]) {
            dfs(arr[node]);
        }

        visited[node] = false;
        done[node] = true;
    }
}
