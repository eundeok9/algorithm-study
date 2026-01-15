import java.io.*;
import java.util.*;
public class Main {
    static class Thing {
        int w, v;
        Thing(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][K+1];

        Thing[] things = new Thing[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            things[i] = new Thing(w, v);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<=K; j++) {
                int weight = things[i].w;
                int value = things[i].v;

                if(j < weight) {
                    if(i==0) dp[i][j] = 0;
                    else dp[i][j] = dp[i-1][j];
                } else {
                    if(i==0) dp[i][j] = value;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
                }
            }
        }

        System.out.println(dp[N-1][K]);
    }
}