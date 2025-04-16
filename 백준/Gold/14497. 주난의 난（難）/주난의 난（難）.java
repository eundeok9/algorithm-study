import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int x1, y1, x2, y2;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        map = new int[N][M];
        visited = new boolean[N][M];
        String s;
        for(int i=0; i<N; i++) {
            s = br.readLine();
            for(int j=0; j<M; j++) {
                char ch = s.charAt(j);
                if(ch=='*' || ch=='#') continue;
                map[i][j] = ch - '0';
            }
        }

        map[x2][y2] = 1;
        System.out.println(bfs());

    }

    public static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x1, y1, 0});
        visited[x1][y1] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == x2 && cur[1] == y2) {
                return cur[2];
            }

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if(map[nx][ny] == 0) {
                            queue.offerFirst(new int[] {nx, ny, cur[2]});
                        } else {
                            queue.offerLast(new int[] {nx, ny, cur[2] + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
