import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int answer = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int maxHeight = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(maxHeight < map[i][j]) {
                    maxHeight = map[i][j];
                }
            }
        }

        // maxHeight일 때는 안전영역이 0이므로 maxHeight - 1 부터 시행
        for(int h=maxHeight-1; h>=0; h--) {

            // bfs로 영역 개수 세기
            int cnt = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && map[i][j] > h) {
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);

        }
        System.out.println(answer);
    }

    public static void bfs(int i, int j, int h) {
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
                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] > h) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}