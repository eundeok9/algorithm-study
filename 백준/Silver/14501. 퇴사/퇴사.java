import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] schedule;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 기간
            schedule[i][1] = Integer.parseInt(st.nextToken()); // 금액
        }

        answer = 0;

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int idx, int pay) {
        if(idx >= N) {
            answer = Math.max(pay, answer);
            return;
        }

        if(idx + schedule[idx][0] <= N) {
            dfs(idx + schedule[idx][0], pay + schedule[idx][1]);
        } else {
            dfs(idx + schedule[idx][0], pay);
        }

        dfs(idx + 1, pay);
    }
}