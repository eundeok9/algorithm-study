import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] board;
    static int[] order;
    static HashMap<Integer, Set<Integer>> likes;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        order = new int[N*N];
        likes = new HashMap<>();
        for(int i=0; i<N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            order[i] = num;

            HashSet<Integer> set = new HashSet<>();
            while(st.hasMoreTokens()) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            likes.put(num, set);
        }

        for(int num: order) {
            place(num);
        }

        System.out.println(calc());
    }

    public static void place(int num) {
        int maxLike = -1; // 조건 1
        int maxEmpty = -1; // 조건 2
        int bestX = -1, bestY = -1; // 조건 3

        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                if(board[x][y] != 0) continue;

                int likeCnt = 0, emptyCnt = 0;

                for(int d=0; d<4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;

                    if(board[nx][ny] == 0) emptyCnt++;
                    else if(likes.get(num).contains(board[nx][ny])) likeCnt++;
                }

                if(maxLike < likeCnt ||
                        (maxLike==likeCnt && maxEmpty < emptyCnt) ||
                        (maxLike==likeCnt && maxEmpty==emptyCnt && (bestX > x || (bestX == x && bestY > y)))) {
                    maxLike = likeCnt;
                    maxEmpty = emptyCnt;
                    bestX = x;
                    bestY = y;
                }

            }
        }
        board[bestX][bestY] = num;
    }

    public static int calc() {
        int sum = 0;

        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                int count = 0;
                int num = board[x][y];
                for(int d=0; d<4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;

                    if(likes.get(num).contains(board[nx][ny])) count++;
                }

                if(count > 0) {
                    sum += (int) Math.pow(10, count - 1);
                }
            }
        }

        return sum;
    }
}