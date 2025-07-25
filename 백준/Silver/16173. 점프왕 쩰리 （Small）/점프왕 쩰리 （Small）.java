import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean isPossible = false;
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
        System.out.println(isPossible ? "HaruHaru" : "Hing");
    }

    static void dfs(int i, int j) {
        if(i == N-1 && j == N-1) {
            isPossible = true;
            return;
        }

        for(int d=0; d<2; d++) {
            int nx = i + dx[d] * map[i][j];
            int ny = j + dy[d] * map[i][j];
            if(nx >= N || ny >= N || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}