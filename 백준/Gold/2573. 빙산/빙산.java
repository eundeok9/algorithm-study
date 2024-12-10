import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();

        int year = 0;
        while(true) {
            int count = 0;
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                return;
            } else if (count >= 2) {
                System.out.println(year);
                return;
            }

            melting();
            year++;
        }
    }

    public static void melting() {
        int[][] newMap = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (check(nx, ny)) continue;
                        if (map[nx][ny] == 0) cnt++;
                    }
                    newMap[i][j] = Math.max((map[i][j] - cnt), 0);
                }
            }
        }

        map = newMap;
    }
    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(check(nx, ny)) continue;
                if(map[nx][ny] != 0 && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

    }

    public static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= M;
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
