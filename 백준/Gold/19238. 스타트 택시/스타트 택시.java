import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int fuel;
    static int[][] map;
    static Passenger[][] passengerMap;
    static int taxiX, taxiY;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Passenger implements Comparable<Passenger> {
        int sx, sy, ex, ey;
        int dist;
        public Passenger(int sx, int sy, int ex, int ey, int dist) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
            this.dist = dist;
        }

        @Override
        public int compareTo(Passenger o) {
            if(this.dist != o.dist) return this.dist - o.dist;
            else if(this.sx != o.sx) return this.sx - o.sx;
            return this.sy - o.sy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 태워야 할 승객 수
        fuel = Integer.parseInt(st.nextToken()); // 초기 연료

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 택시 초기 위치
        st = new StringTokenizer(br.readLine());
        taxiX = Integer.parseInt(st.nextToken()) - 1;
        taxiY = Integer.parseInt(st.nextToken()) - 1;

        // 승객의 위치
        passengerMap = new Passenger[N][N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            passengerMap[sx][sy] = new Passenger(sx, sy, ex, ey, 0);
        }

        int count = 0; // 내려준 승객 수
        while(true) {
            Passenger pass = findPassenger();

            if(pass == null) break; // 태울 수 있는 승객이 없는 경우

            fuel -= pass.dist; // 승객한테 가는 거리

            // 목적지로 가는 거리
            int dist;
            if(pass.sx == pass.ex && pass.sy == pass.ey) {
                dist = 0;
            } else {
                dist = calcDist(pass.sx, pass.sy, pass.ex, pass.ey);

                if(dist == -1) break; // 목적지를 못 가는 경우
            }
            fuel -= dist;

            if(fuel < 0) break; // 목적지 가는 도중에 연료 부족해진 경우

            fuel += (dist * 2);

            count++;

            // 택시 위치 변경
            taxiX = pass.ex;
            taxiY = pass.ey;

            // 태워준 승객 지우기
            passengerMap[pass.sx][pass.sy] = null;
        }

        if(count == M) System.out.println(fuel);
        else System.out.println(-1);
    }

    static Passenger findPassenger() {
        // 택시 위치 = 승객 위치일 땐 그냥 바로 태우면 됨
        if(passengerMap[taxiX][taxiY] != null) {
            return passengerMap[taxiX][taxiY];
        }

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {taxiX, taxiY, 0});
        visited[taxiX][taxiY] = true;

        List<Passenger> passengers = new ArrayList<>(); // 태울 수 있는 승객

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(passengers.size() > M) break;

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny] || map[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cur[2] + 1});
                if(passengerMap[nx][ny] != null  && fuel >= cur[2]+1) {
                    Passenger curP = passengerMap[nx][ny];
                    passengers.add(new Passenger(curP.sx, curP.sy, curP.ex, curP.ey, cur[2]+1));
                }
            }
        }

        if(passengers.isEmpty()) {
            return null;
        }

        Collections.sort(passengers);
        return passengers.get(0);
    }

    static int calcDist(int sx, int sy, int ex, int ey) {
        int[][] visited = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sx, sy});
        visited[sx][sy] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == ex && cur[1] == ey) {
                return visited[cur[0]][cur[1]];
            }

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny] != 0 || map[nx][ny] == 1) continue;

                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                queue.add(new int[] {nx, ny});
            }
        }

        return -1;
    }
}
