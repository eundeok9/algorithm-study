import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // 입력값 처리
        init();

        int year = 0;
        while(true) {
            int count = 0; // 섬으로 연결된 영역의 개수
            visited = new boolean[n][m];

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j); // 영역 찾기
                        count++;
                    }
                }
            }

            if(count == 0) { // 영역이 만들어지지 않을 경우
                System.out.println(0); // 0 출력
                return;
            }
            if(count > 1) { // 영역이 2개 이상이 되는 경우
                System.out.println(year); // 년 출력
                return;
            }

            // 영역이 1개인 경우, 빙산 녹이고 1년 추가
            melting();
            year++;
        }
    }

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 섬의 영역 개수 세기
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(check(nx, ny) && !visited[nx][ny] && map[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }

    public static void melting() {
        int[][] newMap = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] > 0) {
                    int water = 0;
                    for(int d=0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(check(nx, ny) && map[nx][ny] == 0) {
                            water++;
                        }
                    }
                    newMap[i][j] = Math.max(0, map[i][j] - water);
                }
            }
        }
        map = newMap;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
