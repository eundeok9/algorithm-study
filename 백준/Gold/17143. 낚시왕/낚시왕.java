import java.io.*;
import java.util.*;
public class Main {
    static int R, C;
    static Shark[][] sharks;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0; // 낚시왕이 잡은 상어 크기 합
    static class Shark {
        int r, c, speed, dir, size;
        Shark(int r, int c, int speed, int dir, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M==0) {
            System.out.println(0);
            return;
        }

        sharks = new Shark[R][C];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            sharks[r][c] = new Shark(r, c, s, d, z);
        }

        int fishman = 0;
        while(fishman < C) {
            // 현재 열에서 땅과 가장 가까운 상어 포획
            for(int i=0; i<R; i++) {
                if(sharks[i][fishman] != null) {
                    answer += sharks[i][fishman].size;
                    sharks[i][fishman] = null;
                    break;
                }
            }

            // 상어 이동
            move();

            fishman++;
        }

        System.out.println(answer);

    }

    static void move() {
        Shark[][] newShark = new Shark[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(sharks[i][j] != null) {
                    Shark cur = sharks[i][j];
                    int nr = cur.r; int nc = cur.c;
                    int speed = cur.speed; int dir = cur.dir;

                    int cycle = (dir <= 1) ? 2 * (R - 1) : 2 * (C - 1);
                    if (cycle != 0) speed %= cycle;

                    for(int s=0; s<speed; s++) {
                        nr += dx[dir]; nc += dy[dir];
                        if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
                            nr -= dx[dir];
                            nc -= dy[dir];
                            switch(dir) {
                                case 0:
                                    dir = 1;
                                    break;
                                case 1:
                                    dir = 0;
                                    break;
                                case 2:
                                    dir = 3;
                                    break;
                                case 3:
                                    dir = 2;
                                    break;
                            }
                            nr += dx[dir];
                            nc += dy[dir];
                        }
                    }

                    if(newShark[nr][nc] == null || newShark[nr][nc].size < sharks[i][j].size) {
                        newShark[nr][nc] = new Shark(nr, nc, speed, dir, cur.size);
                    }

                }
            }
        }

        for(int i=0; i<R; i++) {
            for (int j = 0; j < C; j++) {
                sharks[i][j] = newShark[i][j];
            }
        }
    }
}
