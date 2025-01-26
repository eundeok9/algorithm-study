import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int lastCheese = 0;

        while(true) {
            int cnt = countCheese(); // 현재 치즈 개수 계산
            if (cnt == 0) {
                break;
            }

            lastCheese = cnt;
            meltCheese(); // 치즈 녹이기
            time++;
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }

    public static int countCheese() {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(cheese[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    public static void meltCheese() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];

        queue.add(new int[] {0, 0,});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
                    if(cheese[nx][ny] == 0) {
                        queue.add(new int[] {nx, ny});
                    } else if(cheese[nx][ny] == 1) {
                        cheese[nx][ny] = 0; // 공기와 닿아 있는 치즈 녹이기
                    }
                    visited[nx][ny] = true;
                }
            }
        }
    }
}