import java.io.*;
import java.util.*;
public class Main {
    static int[] weights;
    static int N;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N+1][15001];
        dfs(0, 0);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int q = Integer.parseInt(st.nextToken());
            if(q > 15000) sb.append("N ");
            else sb.append(dp[N][q] ? "Y " : "N ");
        }
        System.out.println(sb);
    }

    static void dfs(int idx, int weight) {
        if(weight > 15000) return;
        if(idx > N) return;
        if(dp[idx][weight]) return;

        dp[idx][weight] = true;
        if(idx==N) return;

        dfs(idx + 1, weight + weights[idx]);
        dfs(idx + 1, Math.abs(weight - weights[idx]));
        dfs(idx + 1, weight);
    }
}
