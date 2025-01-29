import java.io.*;
import java.util.*;
public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        for(int i=0; i<12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while(true) {
            visited = new boolean[12][6];
            boolean isPopped = false; // 한 번이라도 터졌는지

            for(int i=0; i<12; i++) {
                for(int j=0; j<6; j++) {
                    if(map[i][j] != '.' && !visited[i][j]) {
                        if(bfs(i, j)) {
                            isPopped = true;
                        }
                    }
                }
            }

            if(!isPopped) break;

            gravity();
            answer++;
        }
        System.out.println(answer);
    }

    public static boolean bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> puyoGroup = new ArrayList<>(); // 터질 뿌요 좌표 저장

        queue.add(new int[] {i, j});
        puyoGroup.add(new int[] {i, j});
        visited[i][j] = true;
        char color = map[i][j]; // 현재 뿌요 색

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                if(visited[nx][ny] || map[nx][ny] != color) continue;

                queue.add(new int[] {nx, ny});
                puyoGroup.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        if(puyoGroup.size() >= 4) {
            for(int[] p : puyoGroup) {
                map[p[0]][p[1]] = '.';
            }
            return true;
        }

        return false;
    }

    public static void gravity() {
        for(int j=0; j<6; j++) {
            for(int i=11; i>=0; i--) {
                if(map[i][j] == '.') {
                    int k = i - 1;
                    while(k >= 0 && map[k][j] == '.') k--;

                    if(k>=0) {
                        map[i][j] = map[k][j];
                        map[k][j] = '.';
                    }
                }
            }
        }
    }
}