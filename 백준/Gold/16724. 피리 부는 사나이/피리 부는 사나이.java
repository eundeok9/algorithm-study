import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] finished; // 사이클 판별 완료 되었는지
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        finished = new boolean[N][M];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        int nx = x, ny = y;
        switch (map[x][y]) {
            case 'U': nx--; break;
            case 'D': nx++; break;
            case 'L': ny--; break;
            case 'R': ny++; break;
        }

        if(!visited[nx][ny]) {
            dfs(nx, ny);
        } else if(!finished[nx][ny]) {
            // 방문 했는데 finished가 아니라면 여기에 설치하면 됨
            answer++;
        }

        finished[x][y] = true;
    }
}