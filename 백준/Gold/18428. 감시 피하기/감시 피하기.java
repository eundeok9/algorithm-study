import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static char[][] map;
    static int[] selected;
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

        selected = new int[3];
        Arrays.fill(selected, -1);
        backTracking(0, 0);

        System.out.println(isPossible ? "YES" : "NO");
    }

    static void backTracking(int depth, int start) {
        if(depth == 3) {
            // 감시 피할 수 있는지 확인
            check();
            return;
        }

        for(int i=start; i<N*N; i++) {
            int r = i / N; int c = i % N;
            if(map[r][c] == 'X') {
                selected[depth] = i;
                backTracking(depth + 1, i + 1);
            }
        }
    }

    static void check() {
        // 현재 선택된 칸에 장애물을 설치하는 임시 맵 생성
        char[][] tmpMap = new char[N][N];
        for(int i=0; i<N; i++) {
            tmpMap[i] = Arrays.copyOf(map[i], N);
        }
        for(int i=0; i<3; i++) {
            int num = selected[i];
            int r = num / N; int c = num % N;
            tmpMap[r][c] = 'O';
        }

        for(int[] teacher: teachers) {
            int x = teacher[0]; int y = teacher[1];
            boolean flag = true;
            for(int d=0; d<4; d++) {
                int nx = x, ny = y;
                while(true) {
                    nx += dx[d];
                    ny += dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || tmpMap[nx][ny] == 'O') break;

                    if(tmpMap[nx][ny] == 'S') {
                        flag = false;
                        break;
                    }
                }

                if(!flag) return; // 학생 만났으면 바로 중단
            }
        }

        isPossible = true;
    }
}