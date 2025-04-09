import java.io.*;
import java.util.*;
public class Main {
    static int N, K;
    static int[] belt;
    static boolean[] robot;
    static int step = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2*N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }


        while(true) {
            step++;

            first();
            second();
            third();

            if(!isPossible()) break;
        }

        System.out.println(step);
    }

    /**
     * 벨트와 로봇 배열 시계 방향으로 돌리기
     */
    public static void first() {
        int lastDurability = belt[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = lastDurability;

        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false; // 내리는 위치
    }

    /**
     * 로봇 한 칸씩 이동
     */
    public static void second() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                belt[i + 1]--;
            }
        }
        robot[N - 1] = false;
    }

    /**
     * 로봇 올리기
     */
    public static void third() {
        if (belt[0] > 0 && !robot[0]) {
            robot[0] = true;
            belt[0]--;
        }
    }


    /**
     * 내구도가 0 이상인 칸이 K개 이상인지 체크하는 함수
     * false일 경우 벨트 작동 멈춤
     * @return
     */
    public static boolean isPossible() {
        int cnt = 0;
        for (int d : belt) {
            if (d == 0) cnt++;
        }
        return cnt < K;
    }
}