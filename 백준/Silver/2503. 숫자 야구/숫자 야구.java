import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static boolean[] visited;
    static Info[] info;
    static int answer = 0;
    public static class Info {
        int number, strike, ball;

        Info(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        info = new Info[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            info[i] = new Info(number, strike, ball);
        }

        visited = new boolean[10]; // 1부터 9까지 수 사용 여부
        backTracking("", 0);
        System.out.println(answer);
    }

    public static void backTracking(String s, int depth) {
        if(depth == 3) {
            // 숫자 야구 진행
            boolean flag = true;
            for(int i=0; i<N; i++) {
                if(!playGame(s, String.valueOf(info[i].number), info[i].strike, info[i].ball)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer++;
            }
            return;
        }

        for(int i=1; i<=9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTracking(s + i,depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean playGame(String a, String b, int strike, int ball) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for(int i=0; i<3; i++) {
            if(a.charAt(i) == b.charAt(i)) {
                strikeCnt++;
            }
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(a.charAt(i) == b.charAt(j)) {
                    ballCnt++;
                }
            }
        }

        ballCnt -= strikeCnt;

        return strike == strikeCnt && ball == ballCnt;
    }
}