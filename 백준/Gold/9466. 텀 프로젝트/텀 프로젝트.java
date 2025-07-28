import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            visited = new boolean[N];
            finished = new boolean[N];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken())-1;
            }

            for(int i=0; i<N; i++) {
                if(!visited[i]) {
                    dfs(i);
                }
            }
            sb.append(N - count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x) {
        visited[x] = true;

        int nxt = arr[x];
        if(!visited[nxt]) {
            dfs(nxt);
        } else if(!finished[nxt]) {
            count++;
            while(nxt != x) {
                count++;
                nxt = arr[nxt];
            }
         }

        finished[x] = true; // 노드 탐색 완료
    }
}
