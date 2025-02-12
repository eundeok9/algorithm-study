import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] vip = new int[M];
        for(int i=0; i<M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }


        // 연속된 i개의 (일반)좌석에 대해 자리 배치가 가능한 경우의 수
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int answer = 1;

        if(M > 0) {
            // 첫 vip 좌석 전까지 구간
            answer *= dp[vip[0] - 1];

            // 인접한 vip 좌석 사이의 구간
            for(int i=1; i<M; i++) {
                int gap = vip[i] - vip[i-1] - 1;
                answer *= dp[gap];
            }

            // 마지막 vip 좌석 이후 구간
            answer *= dp[N - vip[M-1]];
        } else {
            answer = dp[N];
        }

        System.out.println(answer);
    }
}