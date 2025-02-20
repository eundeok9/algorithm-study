import java.io.*;
import java.util.*;
public class Main {
    static List<int[]> list;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[9][9];
        list = new ArrayList<>();
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    list.add(new int[] {i, j}); // 빈칸 좌표 저장
                }
            }
        }

        dfs(0);

    }

    public static boolean dfs(int depth) {
        if(depth == list.size()) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }

        for(int i=1; i<10; i++) {
            int x = list.get(depth)[0];
            int y = list.get(depth)[1];

            if(checkRow(x, i) && checkCol(y, i) && checkRect(x, y, i)) {
                map[x][y] = i;
                if(dfs(depth + 1)) {
                    break;
                }
                map[x][y] = 0;
            }
        }

        return false;
    }

    public static boolean checkRow(int x, int num) {
        for(int i=0; i<9; i++) {
            // x열에 num이 있는지 확인
            if(map[x][i] == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCol(int y, int num) {
        for(int i=0; i<9; i++) {
            if(map[i][y] == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRect(int x, int y, int num) {
        // x, y가 속해있는 3x3 정사각형에 num이 있는지
        int startX = x / 3 * 3;
        int startY = y / 3 * 3;

        for(int i=startX; i<startX+3; i++) {
            for(int j=startY; j<startY+3; j++) {
                if(map[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}