import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static int maxCount = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 1, 1 << (map[0][0] - 'A'));

        System.out.println(maxCount);
    }

    public static void dfs(int startX, int startY, int count, int visited) {
        maxCount = Math.max(count, maxCount);

        for(int d=0; d<4; d++) {
            int nx = startX + dx[d];
            int ny = startY + dy[d];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
                int nextChar = map[nx][ny] - 'A';

                if((visited & (1 << nextChar)) == 0) {
                    dfs(nx, ny, count+1, visited | (1 << nextChar));
                }
            }
        }
    }
}
