import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] answer;
    static int[] arr;
    static StringBuilder sb  = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        visited = new boolean[N];
        answer = new int[M];

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if(depth == M) {
            for(int val: answer) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}