import java.io.*;
import java.util.*;
public class Main {
    static final int N = 12;
    static final int M = 6;
    static char[][] map = new char[N][M];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static ArrayList<int[]> puyoGroup;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while(true) {
            visited = new boolean[N][M];
            boolean isPuyo = false;

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] != '.' && !visited[i][j]) {
                        if(bfs(i, j)) {
                            isPuyo = true;
                        }
                    }
                }
            }

            if(!isPuyo) {
                break;
            }

            answer++;

            // 연쇄 발생해서 빈칸이 생긴 곳 채워주기
            gravity();
        }
        System.out.println(answer);
    }

    public static boolean bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;

        puyoGroup = new ArrayList<>();
        puyoGroup.add(new int[] {i, j});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(check(nx, ny) && !visited[nx][ny]) {
                    if(map[nx][ny] == map[i][j]) {
                        visited[nx][ny] = true;
                        puyoGroup.add(new int[] {nx, ny});
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }

        if(puyoGroup.size() < 4) {
            return false;
        }

        for(int[] puyo: puyoGroup) {
            map[puyo[0]][puyo[1]] = '.';
        }

        return true;
    }

    public static void gravity() {
        for(int j=0; j<M; j++) {
            for(int i=N-1; i>=0; i--) {
                if(map[i][j] == '.') {
                    int k = i - 1;
                    while(k >= 0 && map[k][j] == '.') k--;

                    if(k >= 0) {
                        map[i][j] = map[k][j];
                        map[k][j] = '.';
                    }
                }
            }
        }
    }

    public static boolean check(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}