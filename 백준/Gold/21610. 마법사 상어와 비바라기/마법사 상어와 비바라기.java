import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] wasCloud, isCloud; // 과거 구름 있던 곳, 현재 구름 있는 곳
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        isCloud = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isCloud[N-1][0] = isCloud[N-1][1] = isCloud[N-2][0] = isCloud[N-2][1] = true;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            moveCloud(d, s);
            copyWater();
            makeNewCloud();
        }

        int sum = 0;
        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                sum += board[x][y];
            }
        }

        System.out.println(sum);
    }

    public static void moveCloud(int d, int s) {
        wasCloud = new boolean[N][N];

        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                if(isCloud[x][y]) {
                    // 구름 이동할 위치
                    int nx = (x + (dx[d] + N) * s) % N;
                    int ny = (y + (dy[d] + N) * s) % N;

                    board[nx][ny]++; // 구름 위치에 물의 양 1 증가
                    wasCloud[nx][ny] = true; // 이동 후 사라진 구름 위치
                }
            }
        }
    }

    public static void copyWater() {
        // 대각 방향
        int[] diagX = {-1, -1, 1, 1};
        int[] diagY = {-1, 1, 1, -1};

        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                // 원래 구름이 있던 곳(= 물의 양이 증가한 곳)
                if(wasCloud[x][y]) {
                    int count = 0;
                    for(int d=0; d<4; d++) {
                        int nx = x + diagX[d];
                        int ny = y + diagY[d];
                        if(0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] > 0) {
                            count++;
                        }
                    }
                    board[x][y] += count;
                }
            }
        }
    }

    public static void makeNewCloud() {
        boolean[][] newCloud = new boolean[N][N];

        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                if(!wasCloud[x][y] && board[x][y] >= 2) {
                    newCloud[x][y] = true;
                    board[x][y] -= 2;
                }
            }
        }

        isCloud = newCloud;
    }
}