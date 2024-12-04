import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int r;
    static int c;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] map;
    static int[][] fire;
    static int[][] jihoon;
    static Queue<Node> fireQueue = new LinkedList<>();
    static Queue<Node> jihoonQueue = new LinkedList<>();

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        fire = new int[r][c];
        jihoon = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(jihoon[i], -1);
        }

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (s.charAt(j) == 'F') {
                    fireQueue.add(new Node(i, j));
                    fire[i][j] = 0;
                } else if (s.charAt(j) == 'J') {
                    jihoonQueue.add(new Node(i, j));
                    jihoon[i][j] = 0;
                }
            }
        }

        while (!fireQueue.isEmpty()) {
            Node cur = fireQueue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (isEdge(nx, ny)) continue;
                if (fire[nx][ny] >= 0 || map[nx][ny] == '#') continue;
                fire[nx][ny] = fire[cur.x][cur.y] + 1;
                fireQueue.add(new Node(nx, ny));
            }
        }

        while (!jihoonQueue.isEmpty()) {
            Node cur = jihoonQueue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (isEdge(nx, ny)) {
                    System.out.println(jihoon[cur.x][cur.y] + 1);
                    return;
                }
                if (jihoon[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }
                if (fire[nx][ny] >= 0 && fire[nx][ny] <= jihoon[cur.x][cur.y] + 1) {
                    continue;
                }
                jihoon[nx][ny] = jihoon[cur.x][cur.y] + 1;
                jihoonQueue.add(new Node(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static boolean isEdge(int x, int y) {
        return 0 > x || x >= r || 0 > y || y >= c;
    }
}
