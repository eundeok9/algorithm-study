import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int index = 0;
        for(String[] place: places) {
            boolean flag = true;
            for(int i=0; i<5 && flag; i++) {
                for(int j=0; j<5 && flag; j++) {
                    if(place[i].charAt(j) == 'P') {
                        if(!bfs(i, j, place)) {
                            flag = false;
                        }
                    }
                }
            }
            
            answer[index++] = flag ? 1 : 0;
        }
        return answer;
    }
    
    static boolean bfs(int r, int c, String[] p) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (dist >= 2) continue;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (visited[nx][ny]) continue;
                if (p[nx].charAt(ny) == 'X') continue;

                if (p[nx].charAt(ny) == 'P') return false;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }
        return true;
    }
}