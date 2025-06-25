import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] vol = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            vol[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][v]: i 곡 연주 후 볼륨이 v가 될 수 있으면 true
        boolean[][] dp = new boolean[N+1][M+1];
        dp[0][S] = true;

        for(int i=1; i<=N; i++) {
            int diff = vol[i-1];
            // 0부터 M까지 이전 볼륨에서 가능한 볼륨 크기 찾기
            for(int v=0; v<=M; v++) {
                if(!dp[i-1][v]) continue;
                int up = v + diff;
                if(up <= M) dp[i][up] = true;
                int down = v - diff;
                if(down >= 0) dp[i][down] = true;
            }
        }

        int answer = -1;
        for(int v=0; v<=M; v++) {
            if(dp[N][v]) answer = v;
        }
        System.out.println(answer);

    }
}
