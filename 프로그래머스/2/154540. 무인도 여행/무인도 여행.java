import java.util.*;
class Solution {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int sum = 0;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 'X' && !visited[i][j]) {
                    sum = 0;
                    visited[i][j] = true;
                    
                    dfs(i, j);
                    
                    if(sum != 0) {
                        answer.add(sum);
                    }
                }
            }
        }
        
        if(answer.size() == 0) return new int[] {-1};
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static void dfs(int x, int y) {
        sum += (map[x][y] - '0');
        
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[nx][ny] == 'X') continue;
            if(visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}