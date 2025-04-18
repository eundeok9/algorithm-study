import java.io.*;
import java.util.*;
public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            boolean isMoved = false;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        if(bfs(i, j)) {
                            isMoved = true;
                        }
                    }
                }
            }
            if(!isMoved) break;
            answer++;
        }

        System.out.println(answer);
    }

    public static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        visited[x][y] = true;
        list.add(new int[] {x, y});
        queue.add(new int[] {x, y});

        int sum = map[x][y];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(check(nx, ny) && !visited[nx][ny]) {
                    int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
//                    System.out.println(map[x][y] + " " + map[nx][ny] + " " + diff);
                    if(L <= diff && diff <= R) {
                        sum += map[nx][ny];
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        list.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if(list.size() > 1) {
            int popularity = sum / list.size();
            for(int[] arr: list) {
                map[arr[0]][arr[1]] = popularity;
            }
            return true;
        }
        return false;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}