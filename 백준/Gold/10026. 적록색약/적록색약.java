import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer1 = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, map[i][j], false);
                    answer1++;
                }
            }
        }

        int answer2 = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, map[i][j], true);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    static void bfs(int i, int j, char c, boolean isBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0  || ny >= N) continue;
                if(visited[nx][ny]) continue;

                if(isBlind) {
                    // 적록 색약인 경우
                    if(c == 'R' || c == 'G') {
                        if(map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny});
                        }
                    } else {
                        if(map[nx][ny] == 'B') {
                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                } else {
                    if(c == map[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny});
                    }
                }

            }
        }
    }
}
