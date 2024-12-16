import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, H;
    static int[][][] map;
    static boolean hasZero = false;

    static Queue<Node> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static int answer = 0;

    public static class Node {
        int z, x, y;
        Node(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        if(!hasZero) {
           System.out.println(0);
           return;
        }
        bfs();
        for(int i = 0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (map[i][j][k] > answer) {
                        answer = map[i][j][k];
                    }
                }
            }
        }
        System.out.println(answer-1);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 0) {
                        hasZero = true;
                    }
                    else if(map[i][j][k] == 1) {
                        queue.add(new Node(i,j,k));
                    }
                }
            }
        }
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int z = cur.z;
            int x = cur.x;
            int y = cur.y;

            for(int d=0; d<6; d++) {
                int nz = z + dz[d];
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(check(nx, ny, nz)) continue;
                if(map[nz][nx][ny] != 0) continue;
                map[nz][nx][ny] = map[z][x][y] + 1;
                queue.add(new Node(nz, nx, ny));
            }
        }
    }

    public static boolean check(int x, int y, int z) {
        return 0 > x || x >= N || 0 > y || y >= M || 0 > z || z >= H;
    }
}
