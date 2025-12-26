import java.io.*;
import java.util.*;
class Solution {
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(String[] board) {
        int answer = -1;
        
        N = board.length;
        M = board[0].length();
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i].charAt(j)=='R') {
                    answer = bfs(board, i, j);
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static int bfs(String[] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        
        int[][] visited = new int[N][M];
        visited[x][y] = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            x = cur[0];
            y = cur[1];
            
            for(int d=0; d<4; d++) {
                int nx = x;
                int ny = y;
                
                while(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx].charAt(ny) != 'D') {
                    nx += dx[d];
                    ny += dy[d];
                }
                
                nx -= dx[d];
                ny -= dy[d];
                
                if(board[nx].charAt(ny) == 'G') {
                    return visited[x][y];
                }
                
                if(visited[nx][ny] == 0) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }
        
        return -1;
    }
}