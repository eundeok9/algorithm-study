import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        dfs(1, 2, 0);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int dir) {
        if(x == N && y == N) {
            answer++;
            return;
        }

        switch(dir) {
            case 0: // 파이프가 가로 방향일 때
                if(y+1 <= N && map[x][y+1] == 0) {
                    dfs(x, y+1, 0);
                }
                break;
            case 1: // 파이프가 세로 방향일 때
                if(x+1 <= N && map[x+1][y] == 0) {
                    dfs(x+1, y, 1);
                }
                break;
            case 2:
                if(y+1 <= N && map[x][y+1] == 0) { // 가로로 놓을 경우
                    dfs(x, y+1, 0);
                }

                if(x+1 <= N && map[x+1][y] == 0) { // 세로로 놓을 경우
                    dfs(x+1, y, 1);
                }
                break;
        }

        // 대각선은 파이프 방향에 관계 없이 항상 이동 가능
        if(y+1 <= N && x+1 <= N && map[x+1][y] == 0 && map[x][y+1] == 0 && map[x+1][y+1] == 0) {
            dfs(x+1, y+1, 2);
        }
    }
}