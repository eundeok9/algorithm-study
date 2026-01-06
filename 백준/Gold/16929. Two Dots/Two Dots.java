import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static boolean isPossible = false;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int startX, startY;
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
                visited = new boolean[N][M];
                startX = i;
                startY = j;
                if(dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    static boolean dfs(int x, int y, int count) {
        visited[x][y] = true;

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[nx][ny] != map[x][y]) continue;

            if(!visited[nx][ny]) {
                visited[nx][ny] = true;
                if(dfs(nx, ny, count + 1)) return true;
            } else {
                if(count >= 4 && startX == nx && startY == ny) return true;
            }
        }

        return false;
    }
}