import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int cnt;
        int x, y;
        int wall;

        Node(int x, int y, int wall, int cnt) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K+1];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.x == N-1 && cur.y == M-1) {
                return cur.cnt;
            }

            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(check(nx, ny)) continue;

                if(map[nx][ny] == 0 && !visited[nx][ny][cur.wall]) {
                    queue.add(new Node(nx, ny, cur.wall, cur.cnt + 1));
                    visited[nx][ny][cur.wall] = true;
                } else if(map[nx][ny] == 1 && cur.wall < K && !visited[nx][ny][cur.wall + 1]) {
                    queue.add(new Node(nx, ny, cur.wall + 1, cur.cnt + 1));
                    visited[nx][ny][cur.wall + 1] = true;
                }
            }
        }
        return -1;
    }

    static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= M;
    }
}
