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
        if(done[node]) return; // 이미 결성 가능 여부 판단한 학생이므로 return
        
        if(visited[node]) { // 방문을 했었다 == 사이클 구성원
            done[node] = true;
            count++;
        }
        
        visited[node] = true; // 방문 체크
        dfs(arr[node]);
        visited[node] = false; // 방문 체크 초기화
        done[node] = true; // 결성 가능 여부 확인했으니 done 체크
    }
}
