import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] board;
    static int[][] apple;
    static Deque<Node> deque;
    static HashMap<Integer, String> map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // 사과 위치 저장
        K = Integer.parseInt(br.readLine());
        apple = new int[N][N];
        for(int i=0; i<K; i++) {
            st= new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apple[r-1][c-1] = 1;
        }

        // 방향 전환 정보 저장
        L = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        deque = new ArrayDeque<>();
        deque.add(new Node(0, 0));
        board[0][0] = 1;

        int time = 0;
        int dir = 3;
        while(true) {
            Node head = deque.peekLast();

            // 현재 시간에 대한 방향 전환 확인
            if(map.containsKey(time)) {
                String c = map.get(time);
                if(c.equals("L")) {
                    switch(dir) {
                        case 0: dir = 2;
                        break;
                        case 1: dir = 3;
                        break;
                        case 2: dir = 1;
                        break;
                        case 3: dir = 0;
                        break;
                        default: break;
                    }
                }
                if(c.equals("D")) {
                    switch(dir) {
                        case 0: dir = 3;
                            break;
                        case 1: dir = 2;
                            break;
                        case 2: dir = 0;
                            break;
                        case 3: dir = 1;
                            break;
                        default: break;
                    }
                }
            }

            // 뱀의 다음 머리 위치
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];

            // 범위를 나가거나, 자신의 몸과 부딪힌다면 중단
            if(check(nx, ny) || board[nx][ny] == 1) break;
            // 다음 머리 위치 정보 저장
            board[nx][ny] = 1;
            deque.addLast(new Node(nx, ny));
            // 사과가 있는 곳이 아니라면 꼬리 제거
            if(apple[nx][ny] != 1) {
                Node tail = deque.removeFirst();
                board[tail.x][tail.y] = 0;
            }
            // 사과 먹었으면 지워주기
            if(apple[nx][ny] == 1){
                apple[nx][ny] = 0;
            }
            time++;
        }
        System.out.println(time+1);
    }

    public static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= N;
    }
}
