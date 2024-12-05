import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C;
    static char[][][] map;
    static int[][][] visited;
    
    static int endL, endX, endY;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dz = {-1, 0, 1};
    static StringBuilder sb = new StringBuilder();

    static Queue<Node> queue;

    public static class Node {
        int l, x, y;

        Node(int l, int x, int y) {
            this.l = l;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            String s = br.readLine();
            // 종료 조건
            if(s.equals("0 0 0")) {
                break;
            }

            st = new StringTokenizer(s);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[L][R][C];
            visited = new int[L][R][C];
            queue = new LinkedList<>();
            for(int i=0; i<L; i++) {
                for(int j=0; j<R+1; j++) {
                    s = br.readLine();
                    if(j == R) continue;
                    for(int k=0; k<C; k++) {
                        map[i][j][k] = s.charAt(k);
                        if(map[i][j][k] == 'S') {
                            visited[i][j][k] = 1;
                            queue.add(new Node(i, j, k));
                        }
                        if(map[i][j][k] == 'E') {
                            endL = i;
                            endX = j;
                            endY = k;
                        }
                    }
                }
            }
            bfs();

            if(visited[endL][endX][endY] == 0) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in").append(" ").append(visited[endL][endX][endY]-1).append(" ").append("minute(s).\n");
            }
        }
        System.out.println(sb);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int z = cur.l;
            int x = cur.x;
            int y = cur.y;

            if(map[z][x][y] == 'E') {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nz = z + dz[i];
                if (0 > nz || nz >= L) continue; // 범위 벗어남
                if(dz[i] == 0) {
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (0 > nx || nx >= R || 0 > ny || ny >= C) continue; // 범위 벗어남
                        if(visited[nz][nx][ny] > 0) continue; // 이미 방문함
                        if(map[nz][nx][ny] != '#') {
                            visited[nz][nx][ny] = visited[z][x][y] + 1;
                            queue.add(new Node(nz, nx, ny));
                        }
                    }
                } else {
                    if(visited[nz][x][y] > 0) continue; // 이미 방문함
                    if(map[nz][x][y] != '#') {
                        visited[nz][x][y] = visited[z][x][y] + 1;
                        queue.add(new Node(nz, x, y));
                    }
                }

            }
        }
    }
}
