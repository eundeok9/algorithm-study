import java.io.*;
import java.util.*;
public class Main {
    static class FireBall {
        int m, s, d;
        FireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    static int N, M, K;
    static List<FireBall>[][] map;
    static FireBall[] order;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new List[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].add(new FireBall(m, s, d));
        }

        while(K-->0) {
            // 파이어볼 이동하기
            move();
            // 같은 칸에 2개 이상의 파이어볼 있는지 확인하기
            check();
        }

        System.out.println(calc());

    }

    public static void move() {
        List<FireBall>[][] newMap = new ArrayList[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                newMap[i][j] = new ArrayList<>();
            }
        }

        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                if(!map[x][y].isEmpty()) {
                    for(FireBall fireBall: map[x][y]) {
                        int m = fireBall.m;
                        int s = fireBall.s;
                        int d = fireBall.d;

                        int nx = (x + (dx[d] + N) * s ) % N;
                        int ny = (y + (dy[d] + N) * s ) % N;

                        newMap[nx][ny].add(new FireBall(m, s, d));
                    }
                }
            }
        }

        map = newMap;
    }

    public static void check() {
        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                if(map[x][y].size() >= 2) {
                    int size = map[x][y].size();
                    int mSum = 0;
                    int sSum = 0;
                    int evenCnt = 0;
                    int oddCnt = 0;
                    for(FireBall fireBall: map[x][y]) {
                        mSum += fireBall.m;
                        sSum += fireBall.s;
                        if(fireBall.d % 2 == 0) evenCnt++;
                        else oddCnt++;
                    }

                    map[x][y].clear();
                    int[] dir1 = {0, 2, 4, 6};
                    int[] dir2 = {1, 3, 5, 7};

                    if(mSum / 5 == 0) continue; // 질량이 0인 경우는 만들지 않음

                    for(int i=0; i<4; i++) {
                        int newDir = -1;
                        if (size == evenCnt || size == oddCnt) newDir = dir1[i];
                        else newDir = dir2[i];

                        map[x][y].add(new FireBall(mSum / 5, sSum / size, newDir));
                    }

                }
            }
        }
    }

    public static int calc() {
        int sum = 0;
        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                if(!map[x][y].isEmpty()) {
                    for(FireBall fireBall: map[x][y]) {
                        sum += fireBall.m;
                    }
                }
            }
        }
        return sum;
    }
}
