import java.util.*;
import java.io.*;

class Solution {
    static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 하, 우, 상, 좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(input[j]);
                }
            }
            int[][] visited = new int[n][n]; // 방문 여부
            int answer = n * n; // 최악의 경우를 우선 대입
            String[] startInput = br.readLine().split(" ");
            int startX = Integer.parseInt(startInput[0]);
            int startY = Integer.parseInt(startInput[1]);
            String[] endInput = br.readLine().split(" ");
            int endX = Integer.parseInt(endInput[0]);
            int endY = Integer.parseInt(endInput[1]);

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(startX, startY, 0));

            while (!queue.isEmpty()) {
                Point current = queue.poll();
                int x = current.x;
                int y = current.y;
                int now = current.time;
                visited[x][y] = 1;

                if (x == endX && y == endY) {
                    answer = Math.min(answer, now);
                    continue;
                }

                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) { // 범위 체크
                        if (board[nx][ny] == 1) // 지나갈 수 없는 장애물일 때
                            continue;

                        if (visited[nx][ny] == 0) {
                            int nextTime = now;
                            if (board[nx][ny] == 2 && (now - 2) % 3 != 0) {
                                while ((nextTime - 2) % 3 != 0) {
                                    nextTime += 1;
                                }
                            }
                            queue.offer(new Point(nx, ny, nextTime + 1));
                        }
                    }
                }
            }

            if (answer == n * n) {
                answer = -1;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
