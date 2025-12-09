import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};
    static int startX, startY, leverX, leverY, endX, endY;
    static char[][] map;
    static int[][] visited;
    static int N, M;
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if(map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                } else if(map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
            }
        }
        
        int startToLever = bfs(startX, startY, leverX, leverY);
        if(startToLever == -1) {
            return -1;
        }
        
        int leverToExit = bfs(leverX, leverY, endX, endY);
        if(leverToExit  == -1) {
            return -1;
        }
        
        return startToLever + leverToExit;
    }
    
    static int bfs(int sX, int sY, int eX, int eY) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new int[N][M];
        
        queue.offer(new int[] {sX, sY});
        visited[sX][sY] = 1; // 편의상 1부터 시작
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int x = cur[0];
            int y = cur[1];
            
            if(x == eX && y == eY) {
                return visited[x][y] - 1; // 1부터 시작했으므로 1빼고 반환
            }
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny] != 0) continue;
                if(map[nx][ny] == 'X') continue;
                
                visited[nx][ny] = visited[x][y] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }
        
        return -1;
    }
}