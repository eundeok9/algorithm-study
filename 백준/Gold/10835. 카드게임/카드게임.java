import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] left, right;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        left = new int[N];
        right = new int[N];

        dp = new int[N][N];
        for(int i=0; i<N; i++) {
            Arrays.fill(dp[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(0,0));
    }
    
    public static int solve(int l, int r) {
        if(l >= N || r >= N) {
            return 0;
        }
        
        if(dp[l][r] != -1) {
            return dp[l][r];
        }
        
        dp[l][r] = 0;
        
        dp[l][r] = Math.max(dp[l][r], solve(l+1, r));

        dp[l][r] = Math.max(dp[l][r], solve(l+1, r+1));

        if(left[l] > right[r]) {
            dp[l][r] = Math.max(dp[l][r], solve(l, r+1) + right[r]);
        }

        return dp[l][r];
    }
}