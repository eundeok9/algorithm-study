import java.io.*;
public class Main {
    static int N;
    static int answer = 0;
    static int[] columns;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        columns = new int[N];
        backTracking(0);
        System.out.println(answer);
    }

    public static void backTracking(int row) {
        if(row == N) {
            answer++;
            return;
        }

        for(int col = 0; col < N; col++) {
            if(isValid(row, col)) {
                columns[row] = col;
                backTracking(row + 1);
            }
        }
    }

    public static boolean isValid(int row, int col) {
        for(int prevRow = 0; prevRow < row; prevRow++) {
            // 같은 열에 퀸이 있는지 확인
            if(columns[prevRow] == col) {
                return false;
            }
            // 대각선에 퀸이 있는지 확인
            if(Math.abs(row - prevRow) == Math.abs(col - columns[prevRow])) {
                return false;
            }
        }
        return true;
    }
}