import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[] selected = new int[7];
    static boolean[] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = 0;

    static final int N = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[N][N];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 0);

        System.out.println(answer);

    }

    /**
     * 조합을 구해보자
     * @param depth : 학생 수
     * @param yCnt : 임도연파 수
     * @param start : 시작 index
     */
    private static void dfs(int depth, int yCnt, int start) {
        if(yCnt >= 4) return;

        if(depth == 7) {
            visited = new boolean[7];
            bfs();
            return;
        }

        for(int i=start; i<25; i++) {
            selected[depth] = i;
            if(map[i/5][i%5] == 'Y') {
                dfs(depth + 1, yCnt + 1, i+1);
            } else {
                dfs(depth + 1, yCnt, i+1);
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {selected[0]/ 5, selected[0] % 5});
        visited[0] = true;

        int count = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int ni = nx * 5 + ny;

                if(check(nx, ny)) continue;
                for(int j=0; j<7; j++) {
                    if(!visited[j] && selected[j] == ni) {
                        queue.add(new int[] {nx, ny});
                        visited[j] = true;
                        count++;
                    }
                }
            }
        }

        if(count == 7) answer++;
    }

    private static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= N;
    }
}
