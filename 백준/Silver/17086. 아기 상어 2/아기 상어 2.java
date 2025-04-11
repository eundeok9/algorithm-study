import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                answer = Math.max(answer, bfs(i, j));
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int startX, int startY) {
        int cnt = 0;

        int[][] visited = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {startX, startY});
        visited[startX][startY] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if(map[x][y] == 1) {
                cnt = visited[x][y];
                break;
            }

            for(int d=0; d<8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if(visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[x][y] + 1;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }

        }
        return cnt;
    }
}