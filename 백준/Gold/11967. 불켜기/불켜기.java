import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static ArrayList<Point>[][] switches;
    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] isLightUp;
    static boolean[][] visited;
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        switches = new ArrayList[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                switches[i][j] = new ArrayList<>();
            }
        }

        // 각 방에 존재하는 스위치 정보 저장
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switches[x][y].add(new Point(a, b));
        }

        isLightUp = new boolean[N+1][N+1];
        visited = new boolean[N+1][N+1];
        bfs(1, 1);

        System.out.println(answer);
    }

    public static void bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;
        isLightUp[startX][startY] = true;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;

            // 불 켜기
            for(Point p: switches[curX][curY]) {
                if(!isLightUp[p.x][p.y]) {
                    isLightUp[p.x][p.y] = true;
                    answer++; // 불 켠 횟수 증가

                    // 새로 켜진 방이 인접한 방문 가능한 방과 연결되어있는지 확인
                    for(int d=0; d<4; d++) {
                        int nx = p.x + dx[d];
                        int ny = p.y + dy[d];
                        if(0 < nx && nx <= N && 0 < ny && ny <= N) {
                            if(visited[nx][ny]) {
                                visited[p.x][p.y] = true;
                                queue.add(new Point(p.x, p.y));
                                break;
                            }
                        }
                    }
                }
            }

            // 인접한 방 방문 가능한지 확인
            for(int d=0; d<4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                if(0 < nx && nx <= N && 0 < ny && ny <= N) {
                    if(isLightUp[nx][ny] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}