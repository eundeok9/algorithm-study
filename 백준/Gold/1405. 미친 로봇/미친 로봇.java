import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static double[] dirPossibility = new double[4];
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            dirPossibility[i] = (double) Integer.parseInt(st.nextToken()) / 100;
        }

        int S = 2 * N + 1;
        visited = new boolean[S][S];

        int startX = N, startY = N;
        visited[startX][startY] = true;

        double answer = dfs(0, startX, startY, 1.0);
        System.out.println(answer);
    }

    static double dfs(int depth, int x, int y, double p) {
        if(depth == N) return p; // N번 이동 끝났으면 현재 확률 반환

        double sum = 0.0;
        for(int i=0; i<4; i++) {
            if (dirPossibility[i] == 0) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            sum += dfs(depth + 1, nx, ny, p * dirPossibility[i]);
            visited[nx][ny] = false;
        }

        return sum;
    }
}