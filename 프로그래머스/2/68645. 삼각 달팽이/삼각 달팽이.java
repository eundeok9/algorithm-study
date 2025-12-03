class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        
        if(n==1) {
            int[] answer = {1};
            return answer;
        }
        
        int curX = 0, curY = 0;
        int num = 1;
        int d = 0;
        
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        while(true) {
            if(map[curX][curY] != 0) break;
            map[curX][curY] = num++;
            
            curX += dx[d];
            curY += dy[d];
            
            if(curX < 0 || curX >= n || curY < 0 || curY >= n || map[curX][curY] != 0) {
                curX -= dx[d];
                curY -= dy[d];
                d = (d+1) % 3;
                curX += dx[d];
                curY += dy[d];
            }
        }
        
        int[] answer = new int[num-1];
        
        int index = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] != 0) {
                    answer[index++] = map[i][j];
                }
            }
        }
        
        return answer;
    }
}