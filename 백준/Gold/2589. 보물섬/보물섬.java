import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static char[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 'L') {
                    visited = new int[N][M];
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer-1);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if(visited[nx][ny] == 0 && map[nx][ny] == 'L') {
                        visited[nx][ny] = visited[x][y] + 1;
                        queue.add(new int[] {nx, ny});
                        answer = Math.max(visited[x][y] + 1, answer);
                    }
                }
            }
        }
    }
}
