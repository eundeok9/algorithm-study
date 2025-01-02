import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        init();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 'L') {
                    dist = new int[N][M];
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer - 1);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        dist[i][j] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(check(nx, ny)) continue;
                if(map[nx][ny] == 'W') continue;
                if(dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new int[] {nx, ny});
                answer = Math.max(answer, dist[x][y] + 1);
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= M;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}