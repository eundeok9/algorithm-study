import java.io.*;
import java.util.*;

public class Main {

    static int dx[] = {-2, -2, -1, -1, 2, 2, 1, 1};
    static int dy[] = {-1, 1, -2, 2, -1, 1, -2, 2};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int length;
    static int[][] map;

    public static class Node {
        int x, y;

        Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        Queue<Node> queue = new LinkedList<>();

        for(int t=0; t<tc; t++) {
            length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            if(startX == endX && startY == endY) {
                System.out.println(0);
                continue;
            }
            
            map = new int[length][length];
            for(int i=0; i<length; i++) {
                Arrays.fill(map[i], -1);
            }

            map[startX][startY] = 0;
            queue.add(new Node(startX, startY));

            while(!queue.isEmpty()) {
                Node cur = queue.poll();
                for(int d=0; d<8; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(check(nx, ny) || map[nx][ny] >= 0) continue;
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
            System.out.println(map[endX][endY]);
        }

    }

    public static boolean check(int x, int y) {
        return 0 > x || x >= length || 0 > y || y >= length;
    }
}
