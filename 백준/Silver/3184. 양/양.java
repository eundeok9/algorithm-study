import java.io.*;
import java.util.*;
public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int wolf = 0, sheep = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] != '#' && !visited[i][j]) {
                    int[] count = bfs(i, j);

                    // 늑대의 수 >= 양의 수
                    if(count[0] >= count[1]) {
                        wolf += count[0];
                    } else {
                        sheep += count[1];
                    }
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    static int[] bfs(int i, int j) {
        int wolf = 0, sheep = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(map[cur[0]][cur[1]] == 'o') sheep++;
            else if(map[cur[0]][cur[1]] == 'v') wolf++;

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(0 > nx || nx >= R || 0 > ny || ny >= C || visited[nx][ny])  continue;
                if(map[nx][ny] == '#') continue;

                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }

        return new int[] {wolf, sheep};
    }
}