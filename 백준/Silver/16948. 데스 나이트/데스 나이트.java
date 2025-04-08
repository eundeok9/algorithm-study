import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int r1, c1, r2, c2;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int[][] visited;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        visited = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(visited[i], -1);
        }

        bfs(r1, c1);

        System.out.println(answer);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == r2 && cur[1] == c2) {
                answer = visited[cur[0]][cur[1]];
                return;
            }

            for(int d=0; d<6; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(0 <= nx && nx < N && 0<= ny && ny < N) {
                    if(visited[nx][ny] == -1) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
    }
}