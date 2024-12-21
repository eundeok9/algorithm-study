import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static boolean[] visited;
    static int[] numbers;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int sum, int index, int count) {
        if(sum == S && count != 0) answer++;

        for(int i=index; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(sum + numbers[i], i+1, count + 1);
                visited[i] = false;
            }
        }
    }
}
