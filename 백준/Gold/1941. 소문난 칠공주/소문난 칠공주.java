import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int N = 5; // 5*5
    static char[][] map = new char[N][N];

    static int[] selected = new int[7];
    static boolean[] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        init();
        combination(0, 0, 0);
        System.out.println(answer);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    public static void combination(int depth, int yCnt, int start) {
        if(yCnt >= 4) return;

        if(depth == 7) {
            visited = new boolean[7];
            bfs();
            return;
        }

        for(int i=start; i<25; i++) {
            selected[depth] = i;
            if(map[i/5][i%5] == 'Y') {
                combination(depth + 1, yCnt+1, i + 1);
            } else {
                combination(depth + 1, yCnt, i+1);
            }
        }
    }

    public static void bfs() {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {selected[0] / 5, selected[0] % 5});
        visited[0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int ni = nx * 5 + ny;
                if(check(nx, ny)) continue;
                for(int i=0; i<7; i++) {
                    if(!visited[i] && selected[i] == ni) {
                        queue.add(new int[] {nx, ny});
                        visited[i] = true;
                        count++;
                    }
                }
            }
        }
        if(count == 7) answer++;
    }

    public static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= N;
    }
}
