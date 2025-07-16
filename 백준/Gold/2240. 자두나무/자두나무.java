import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] fall = new int[T+1];
        for(int t=1; t<=T; t++) {
            fall[t] = Integer.parseInt(br.readLine());
        }

        // dp[시간][이동횟수][위치]
        int[][][] dp = new int[T+1][W+1][2];

        if(fall[1] == 1) {
            dp[1][0][0] = 1; // 1초, 0번 이동, 1번 나무 아래
        } else {
            dp[1][1][1] = 1; // 1초, 1번 이동, 2번 나무 아래
        }

        for(int t=2; t<=T; t++) {
            for(int w=0; w<=W; w++) {
                for(int pos=0; pos<=1; pos++) {
                    int curTree = (fall[t] == pos + 1) ? 1 : 0; // 현재 위치에서 자두가 떨어지는지

                    // 같은 위치 유지
                    dp[t][w][pos] = dp[t-1][w][pos] + curTree;

                    // 이동한 경우
                    if(w>0) {
                        dp[t][w][pos] = Math.max(dp[t][w][pos], dp[t-1][w-1][1-pos] + curTree);
                    }
                }
            }
        }

        int answer = 0;
        for(int w=0; w<=W; w++) {
            answer = Math.max(answer, Math.max(dp[T][w][0], dp[T][w][1]));
        }
        System.out.println(answer);
    }
}