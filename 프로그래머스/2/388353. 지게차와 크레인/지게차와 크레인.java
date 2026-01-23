import java.util.*;
class Solution {
    static int n, m;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        
        int answer = n*m;
        
        map = new char[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = storage[i].charAt(j);
            }
        }
        
        for(String request: requests) {
            int size = request.length();
            char c = request.charAt(0);
            List<int[]> list = new ArrayList<>();
         
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] == c) {
                        if(size == 1) {
                            visited = new boolean[n][m];
                            if(dfs(i, j)) {
                                list.add(new int[] {i, j});
                            }
                        } else {
                            list.add(new int[] {i, j});
                        }
                    }
                }
            }
            
            for(int[] arr: list) {
                // System.out.println(arr[0] + " " + arr[1]);
                map[arr[0]][arr[1]] = '?';
                answer--;
            }
        }
        return answer;
    }
    
    static boolean dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) return true;
            
            if(visited[nx][ny]) continue;
            if(map[nx][ny] != '?') continue;
            if(dfs(nx, ny)) {
                return true;
            }
        }
        
        return false;
    }
}