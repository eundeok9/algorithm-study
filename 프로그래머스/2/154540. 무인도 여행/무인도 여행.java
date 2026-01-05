import java.util.*;
class Solution {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // static int sum = 0;
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
                    int sum = bfs(i, j);
                    
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
    
    static int bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        
        int sum = 0;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            sum += map[cur[0]][cur[1]] - '0';
            
            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny] == 'X') continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
            }
        }
        
        return sum;
    }
}