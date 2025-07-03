import java.io.*;
import java.util.*;
public class Main {
    static final int N = 5;
    static int[][] map = new int[N][N];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                dfs(i, j, String.valueOf(map[i][j]), 0);
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int x, int y, String s, int depth) {
        if(set.contains(s)) return;

        if(depth == 5) {
            set.add(s);
            return;
        }

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            dfs(nx, ny, s + map[nx][ny], depth + 1);
        }
    }
}
