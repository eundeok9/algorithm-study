import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static class Egg {
        int s, w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
    static Egg[] eggs;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }
        backTracking(0);
        System.out.println(answer);
    }

    public static void backTracking(int cur) {
        if(cur == N) {
            // 깨진 계란 수 세고 return
            int cnt = 0;
            for(int i=0; i<N; i++) {
                if(eggs[i].s <= 0) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
            return;
        }

        // 현재 계란이 이미 깨져있는 경우
        if(eggs[cur].s <= 0) {
            backTracking(cur + 1);
            return;
        }

        boolean hit = false; // 현재 계란으로 다른 계란 칠 수 있는지
        for (int i = 0; i < N; i++) {
            if(i!=cur && eggs[i].s > 0) {
                hit = true;

                eggs[cur].s -= eggs[i].w;
                eggs[i].s -= eggs[cur].w;

                backTracking(cur + 1);

                eggs[cur].s += eggs[i].w;
                eggs[i].s += eggs[cur].w;
            }
        }
        
        // 현재 계란으로 아무 계란도 칠 수 없는 경우
        if(!hit) {
            backTracking(cur + 1);
        }
    }
}