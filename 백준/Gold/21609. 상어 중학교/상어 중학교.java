import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class BlockGroup implements Comparable<BlockGroup> {
        int x, y, rainbow, size; // 기준 블록의 좌표, 블록 그룹의 크기
        List<int[]> blocks; // 그룹에 속한 블록 좌표들
        BlockGroup(int x, int y, int rainbow, int size, List<int[]> blocks) {
            this.x = x;
            this.y = y;
            this.rainbow = rainbow;
            this.size = size;
            this.blocks = blocks;
        }

        public int compareTo(BlockGroup o) {
            if(this.size != o.size) {
                return o.size - this.size;
            } else if(this.rainbow != o.rainbow) {
                return  o.rainbow - this.rainbow;
            } else if(this.x != o.x) {
                return o.x - this.x;
            } else {
                return o.y - this.y;
            }
        }
    }
    static List<BlockGroup> blockGroups;
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            // 블록 그룹 만들기 by BFS
            blockGroups = new ArrayList<>();
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]&& map[i][j] > 0) {
                        bfs(i, j);
                    }
                }
            }

            // 블록그룹 없으면 끝내기
            if(blockGroups.isEmpty()) {
                break;
            }

            // 크기가 가장 큰 블록 그룹 찾기
            Collections.sort(blockGroups);
            BlockGroup blockGroup = blockGroups.get(0);

            // 블록 그룹의 블록 제거
            for(int[] b: blockGroup.blocks) {
                map[b[0]][b[1]] = -9;
            }
            score += blockGroup.size * blockGroup.size;

            // 중력
            gravity();

            // 반시계 방향으로 90도 회전
            rotate();

            // 중력
            gravity();
        }

        System.out.println(score);
    }

    static void bfs(int x, int y) {
        int color = map[x][y];
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> blocks = new ArrayList<>();
        List<int[]> rainbows = new ArrayList<>();

        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        blocks.add(new int[] {x, y});

        int minR = x;
        int minC = y;
        int rainbow = 0;
        int size = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == color || map[nx][ny] == 0) {
                    visited[nx][ny] = true;

                    queue.offer(new int[] {nx, ny});
                    blocks.add(new int[] {nx, ny});
                    size++;

                    if(map[nx][ny] == 0) {
                        rainbow++;
                        rainbows.add(new int[] {nx, ny});
                    } else {
                        if(nx < minR || (nx == minR && ny < minC)) {
                            minR = nx;
                            minC = ny;
                        }
                    }
                }
            }
        }

        for(int[] r: rainbows) {
            visited[r[0]][r[1]] = false;
        }

        if(size >= 2) {
            blockGroups.add(new BlockGroup(minR, minC, rainbow, size, blocks));
        }

    }

    static void gravity() {
        for(int c=0; c<N; c++) {
            int j=N-1;

            for(int i=N-1; i>=0; i--) {
                if(map[i][c] == -9) continue; // 빈칸이면 넘어가
                if(map[i][c] == -1) { // 검은색 블록이면
                    j=i-1;
                    continue;
                }

                // 일반 블록(0 이상) 발견하면
                if(i!=j) {
                    map[j][c] = map[i][c];
                    map[i][c] = -9;
                }
                j--;
            }
        }
    }

    static void rotate() {
        int[][] tmpMap = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                tmpMap[N-1-j][i] = map[i][j];
            }
        }

        map = tmpMap;
    }

    static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}