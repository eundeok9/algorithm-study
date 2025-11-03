import java.io.*;
import java.util.*;
public class Main {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[R-1][0] = true;
        dfs(R-1, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int curX, int curY, int dist) {
        if(curX == 0 && curY == C-1) {
            if(dist == K) {
                answer++;
            }
            return;
        }

        for(int d=0; d<4; d++) {
            int nx = curX + dx[d];
            int ny = curY + dy[d];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(map[nx][ny] == 'T') continue;
            if(dist >= K) continue;
            if(visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            dfs(nx, ny, dist+1);
            visited[nx][ny] = false;
        }
    }
}