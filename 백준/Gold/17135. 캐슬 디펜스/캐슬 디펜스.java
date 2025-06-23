import java.io.*;
import java.util.*;
public class Main {
    static int N, M, D, maxKill = 0;
    static int[][] map;
    static int[] archers = new int[3];

    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;
            Point o = (Point) obj;
            return this.x == o.x && this.y == o.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(maxKill);

    }

    static void combi(int idx, int start) {
        if(idx == 3) {
            // 궁수 3명의 위치 정했다면 공격
            attack();
            return;
        }

        for(int i=start; i<M; i++) {
            archers[idx] = i;
            combi(idx + 1, i + 1);
        }
    }

    static void attack() {
        int[][] newMap = copyMap(map);
        int kill = 0;

        for(int i=0; i<N; i++) {
            Set<Point> targets = new HashSet<>();

            for(int a=0; a<3; a++) {
                Point target = findTarget(newMap, archers[a]);
                if(target != null) {
                    targets.add(target);
                }
            }

            // 타겟 제거
            for(Point p: targets) {
                if(newMap[p.x][p.y] == 1) {
                    newMap[p.x][p.y] = 0;
                    kill++;
                }
            }

            // 적 아래로 이동
            for(int row = N-1; row > 0; row--) {
                for(int col = 0; col < M; col++) {
                    newMap[row][col] = newMap[row-1][col];
                }
            }
            Arrays.fill(newMap[0], 0);
        }

        maxKill = Math.max(maxKill, kill);
    }

    static Point findTarget(int[][] map, int archerY) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Point(N-1, archerY, 1));
        visited[N-1][archerY] = true;

        int[] dx = {0, -1, 0}; // 좌, 상, 우
        int[] dy = {-1, 0, 1};

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.dist > D) continue;

            if(map[cur.x][cur.y] == 1) {
                return cur;
            }

            for(int d=0; d<3; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny, cur.dist + 1));
            }
        }

        return null;
    }

    static int[][] copyMap(int[][] src) {
        int[][] newMap = new int[N][M];
        for(int i=0; i<N; i++) {
            newMap[i] = Arrays.copyOf(src[i], M);
        }
        return newMap;
    }
}
