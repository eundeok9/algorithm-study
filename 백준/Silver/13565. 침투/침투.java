import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][M];
        boolean flag = false;
        for(int i=0; i<M; i++) {
            if(map[0][i] == '0' && !visited[0][i]) {
                if(backTracking(0, i)) {
                    flag = true;
                    break;
                }
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    public static boolean backTracking(int x, int y) {
        if(x == N-1) {
            return true;
        }

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                if(!visited[nx][ny] && map[nx][ny] == '0') {
                    visited[nx][ny] = true;
                    if(backTracking(nx, ny)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}