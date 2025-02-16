import java.io.*;
import java.util.*;
public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    // 상하좌우, 대각 이동 방향
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0;
            visited = new boolean[h][w];
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        island++;
                    }
                }
            }

            sb.append(island).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0; d<8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}