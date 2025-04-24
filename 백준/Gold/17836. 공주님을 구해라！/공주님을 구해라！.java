import java.io.*;
import java.util.*;
public class Main {
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Node {
        int x, y, cnt;
        boolean isSword;
        Node(int x, int y, int cnt, boolean isSword) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isSword = isSword;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // [n][m][0]: 검 없음, [n][m][1]: 검 있음
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if(answer <= T && answer > 0) {
            System.out.println(answer);
        } else {
            System.out.println("Fail");
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int x= cur.x;
            int y = cur.y;
            int cnt = cur.cnt;
            boolean isSword = cur.isSword;

            if(x == N-1 && y == M-1) {
                answer = cnt;
                return;
            }

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(!check(nx, ny)) continue;

                if(isSword) {
                    if(visited[nx][ny][1]) continue;

                    q.add(new Node(nx, ny, cnt+1, true));
                    visited[nx][ny][1] = true;
                } else {
                    if(map[nx][ny] == 1) continue;
                    if(visited[nx][ny][0]) continue;
                    boolean sword = map[nx][ny] == 2;
                    q.add(new Node(nx, ny, cnt +1, sword));
                    visited[nx][ny][0] = true;
                    if(sword) visited[nx][ny][1] = true;
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}