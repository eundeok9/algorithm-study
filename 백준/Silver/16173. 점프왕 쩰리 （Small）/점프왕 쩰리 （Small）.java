import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println("Hing");
    }

    static void dfs(int startX, int startY) {
        if(startX == N-1 && startY == N-1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for(int d=0; d<2; d++) {
            int nx = startX + dx[d] * map[startX][startY];
            int ny = startY + dy[d] * map[startX][startY];
            if(nx >= N || ny >= N || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}