import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] isAir;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cheeseCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheeseCnt = 0;
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }

        int answer = 0;
        while(cheeseCnt > 0) {
            answer++;
            // 외부 공기인 곳을 먼저 찾기 isAir[i][j] = -1;
            isAir = new boolean[N][M];
            visited = new boolean[N][M];
            airCheck(0, 0); // 가장자리는 치즈가 없으므로 0,0에서 시행

            // 치즈 녹이기
            melting();
        }
        System.out.println(answer);
    }

    public static void airCheck(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (map[nx][ny] != 1 && !isAir[nx][ny] && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        isAir[nx][ny] = true;
                        visited[nx][ny] = true;
                    }
                }
            }
        }

//        System.out.println("---------");
//        for(int x=0; x<N; x++) {
//            for(int y=0; y<M; y++) {
//                System.out.print((isAir[x][y]? 1 : 0));
//            }
//            System.out.println();
//        }
    }

    public static void melting() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 치즈인 곳의 사방탐색
                if(map[i][j] == 1) {
                    int cnt = 0;
                    for(int d=0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                            if (isAir[nx][ny]) {
                                cnt++;
                            }
                        }
                    }

                    if(cnt >= 2) {
                        map[i][j] = 2;
                        cheeseCnt--;
                    }
                }
            }
        }
    }
}