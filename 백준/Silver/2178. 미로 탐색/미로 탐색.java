import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == N-1 && cur[1] == M-1) {
                return visited[cur[0]][cur[1]];
            }

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny] != 0) continue;
                if(map[nx][ny] == '0') continue;

                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }

        return -1;
    }
}