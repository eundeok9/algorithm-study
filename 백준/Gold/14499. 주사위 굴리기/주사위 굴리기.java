import java.io.*;
import java.util.*;
public class Main {
    static int N, M, x, y, k;
    static int[][] map;
    static int[] dice = new int[7]; // 주사위 면
    static int[] dx = {0, 0, -1, 1}; // 동 서 북 남
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++) {
            int d = Integer.parseInt(st.nextToken()) - 1;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            // 주사위 굴리기
            roll(d);

            x = nx;
            y = ny;

            if(map[x][y] == 0) { // 이동한 위치가 빈칸이라면
                map[x][y] = dice[6]; // 바닥면 -> 지도
            } else {
                dice[6] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[1]).append('\n');
        }
        System.out.println(sb);
    }

    static void roll(int dir) {
        int[] temp = dice.clone();

        switch(dir) {
            case 0: // 동쪽
                dice[1] = temp[4];
                dice[3] = temp[1];
                dice[6] = temp[3];
                dice[4] = temp[6];
                break;
            case 1: // 서쪽
                dice[1] = temp[3];
                dice[4] = temp[1];
                dice[6] = temp[4];
                dice[3] = temp[6];
                break;
            case 2: // 북쪽
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[6] = temp[2];
                dice[5] = temp[6];
                break;
            case 3: // 남쪽
                dice[1] = temp[2];
                dice[5] = temp[1];
                dice[6] = temp[5];
                dice[2] = temp[6];
                break;
        }

    }
}