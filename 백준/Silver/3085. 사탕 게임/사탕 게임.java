import java.io.*;
public class Main {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int result = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 오른쪽과 교환
                if(j+1 < N) {
                    swap(i, j, i, j+1);
                    result = Math.max(result, check());
                    swap(i, j, i, j+1);
                }

                // 아래쪽과 교환
                if(i+1<N) {
                    swap(i, j, i+1, j);
                    result = Math.max(result, check());
                    swap(i, j, i+1, j);
                }
            }
        }
        System.out.println(result);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char tmp = map[x1][y1];
         map[x1][y1] = map[x2][y2];
         map[x2][y2] = tmp;
    }

    static int check() {
        int maxCnt = 1;

        // 행검사
        for(int i=0; i<N; i++) {
            int cnt = 1;
            for(int j=1; j<N; j++) {
                if(map[i][j] == map[i][j-1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }
        }

        // 열검사
        for(int j=0; j<N; j++) {
            int cnt = 1;
            for(int i=1; i<N; i++) {
                if(map[i][j] == map[i-1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxCnt = Math.max(cnt, maxCnt);
            }
        }

        return maxCnt;
    }
}