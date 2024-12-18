import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int num = 0;
        int goalX = 0;
        int goalY = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = ++num;
                if(num == K) {
                    goalY = j;
                    goalX = i;
                }
            }
        }

        int res1 = 1; // 시작점 -> O 까지 가능한 경우의 수
        int res2 = 1; // O -> 도착점까지 가능한 경우의 수
        if(K != 0) {
            dfs(0, 0, goalX, goalY);
            res1 = result;
        }
        result = 0;
        dfs(goalX, goalY, N-1, M-1);
        res2 = result;
        if(res1 == 0) res1 = 1;
        if(res2 == 0) res2 = 1;
        System.out.println(res1 * res2);
    }

    public static void dfs(int startX, int startY, int goalX, int goalY) {
        if(startX == goalX && startY == goalY) {
            result++;
            return;
        }
        if(startX > goalX || startY > goalY) return;

        dfs(startX + 1, startY, goalX, goalY);
        dfs(startX, startY+1, goalX, goalY);
    }
}
