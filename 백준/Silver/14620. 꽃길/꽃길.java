import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int sum) {
        if(depth == 3) {
            answer = Math.min(answer, sum);
            return;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(isPossible(i, j)) {
                    int tmpSum = getSum(i, j);
                    setVisited(i, j, true);
                    dfs(depth+1, sum+tmpSum);
                    setVisited(i, j, false);
                }
            }
        }
    }

    static boolean isPossible(int x, int y) {
        if(visited[x][y]) return false; // 다른 꽃잎과 겹치는 경우

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 1 || nx > N || ny < 1 || ny > N) return false; // 화단 넘어가는 경우
            if(visited[nx][ny]) return false; // 다른 꽃잎과 겹치는 경우
        }

        return true;
    }

    static int getSum(int x, int y) {
        int sum = map[x][y];
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            sum += map[nx][ny];
        }

        return sum;
    }

    static void setVisited(int x, int y, boolean flag) {
        visited[x][y] = flag;
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            visited[nx][ny] = flag;
        }
    }
}