import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int sharkSize = 2; // 상어 크기
    static int eatCnt = 0; // 현재 크기에서 먹은 물고기 수
    static int time = 0;
    static int[][] map;
    // 조건에 따라 상, 좌, 우, 하 순서로 탐색
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int sharkX, sharkY;
    static class Fish implements Comparable<Fish> {
        int x, y, dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if(this.dist != o.dist) return this.dist - o.dist;
            if(this.x != o.x) return this.x - o.x;
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }
        
        // 더이상 먹을 수 있는 물고기가 없을 때까지 반복
        while(true) {
            Fish fish = findFish(); // 이번 턴에 먹을 물고기 찾기
            if(fish == null) break;

            sharkX = fish.x;
            sharkY = fish.y;
            time += fish.dist;
            eatCnt++;
            if(eatCnt == sharkSize) {
                sharkSize++;
                eatCnt = 0;
            }
            map[sharkX][sharkY] = 0;
        }
        System.out.println(time);
    }

    static Fish findFish() {
        boolean[][] visited = new boolean[N][N];
        int[][] distMap = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();
        List<Fish> fishes = new ArrayList<>();

        queue.add(new int[] {sharkX, sharkY});
        visited[sharkX][sharkY] = true;

        int minDist = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dist = distMap[cur[0]][cur[1]];
            if(dist > minDist) break;

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny] || map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                distMap[nx][ny] = dist + 1;

                // 먹을 수 있는 물고기일 때
                if(map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                    fishes.add(new Fish(nx, ny, dist+1));
                    minDist = dist + 1;
                } else {
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        if(fishes.isEmpty()) return null;
        Collections.sort(fishes);
        return fishes.get(0);
    }
}