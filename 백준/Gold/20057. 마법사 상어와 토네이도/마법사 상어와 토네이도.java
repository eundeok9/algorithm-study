import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dist = {1, 1, 2, 2}; // 토네이도 이동 거리 => 2씩 증가시켜줘야함

    static int[][] dsx = {{-1, 1, -2, -1, 1, 2, -1, 1, 0},
                        {-1, -1, 0, 0, 0, 0, 1, 1, 2},
                        {1, -1, 2, 1, -1, -2, 1, -1, 0},
                        {1, 1, 0, 0, 0, 0, -1, -1, -2}};
    static int[][] dsy = {{1, 1, 0, 0, 0, 0, -1, -1, -2},
            {-1, 1, -2, -1, 1, 2, -1, 1, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2},
            {1, -1, 2, 1, -1, -2, 1, -1, 0}};
    static int[] sandRatio = {1, 1, 2, 7, 7, 2, 10, 10, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(calcSand(N/2, N/2));
    }

    static int calcSand(int x, int y) {
        int outSandAmount = 0;

        int curX = x;
        int curY = y;

        while(true) {
            for(int d=0; d<4; d++) {
                for(int move=0; move<dist[d]; move++) {
                    // 현재 위치에서 이동
                    int nx = curX + dx[d];
                    int ny = curY + dy[d];

                    if(check(nx, ny)) {
                        return outSandAmount;
                    }

                    // 이동한 위치의 모래 뿌리기
                    int sand = map[nx][ny];
                    map[nx][ny] = 0;
                    int spreadTotal = 0; // 흩뿌려진 모래의 총량

                    for(int i=0; i<9; i++) {
                        int sX = nx + dsx[d][i];
                        int sY = ny + dsy[d][i];
                        int spreadAmount = (sand * sandRatio[i]) / 100; // 흩뿌려지는 양

                        if(check(sX, sY)) {
                            outSandAmount += spreadAmount;
                        } else {
                            map[sX][sY] += spreadAmount;
                        }
                        spreadTotal += spreadAmount;
                    }

                    int aX = nx + dx[d];
                    int aY = ny + dy[d];
                    int alphaAmount = sand - spreadTotal; // 흩뿌려지고 남은 모래는 alpha로
                    if(check(aX, aY)) {
                        outSandAmount += alphaAmount;
                    } else {
                        map[aX][aY] += alphaAmount;
                    }

                    curX = nx;
                    curY = ny;
                }
            }

            for(int index = 0; index < 4; index++) {
                dist[index] += 2;
            }
        }
    }

    static boolean check(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}
