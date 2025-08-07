import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static char[][] map;
    static boolean isPossible = false;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> teachers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        teachers = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'T') {
                    teachers.add(new int[] {i, j});
                }
            }
        }

        backTracking(0, 0);

        System.out.println(isPossible ? "YES" : "NO");
    }

    static void backTracking(int depth, int start) {
        if(isPossible) return; // 이미 가능하다고 판단했으면 종료

        if(depth == 3) {
            // 감시 피할 수 있는지 확인
            if(check()) {
                isPossible = true;
            }
            return;
        }

        for(int i=start; i<N*N; i++) {
            int r = i / N; int c = i % N;
            if(map[r][c] == 'X') {
                map[r][c] = 'O'; // 벽 설치
                backTracking(depth + 1, i + 1);
                map[r][c] = 'X'; // 복구
            }
        }
    }

    static boolean check() {

        for(int[] teacher: teachers) {
            int x = teacher[0]; int y = teacher[1];

            for(int d=0; d<4; d++) {
                int nx = x, ny = y;
                while(true) {
                    nx += dx[d];
                    ny += dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 'O') break;

                    if(map[nx][ny] == 'S') {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}