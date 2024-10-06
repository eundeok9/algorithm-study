class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                answer[i][j] = 0;
            }
        }
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        
        int num = 1;
        int x = 0;
        int y = 0;
        int d = 0;
        for(int i=0; i<n*n; i++) {
            answer[x][y] = num;
            num += 1;
            
            // 다음 위치로 이동
            x += dx[d];
            y += dy[d];
            
            // 범위 넘어가면 방향 전환
            if(0>x || x>=n || 0>y || y>=n || (answer[x][y] != 0)) {
                x -= dx[d];
                y -= dy[d];
                d = (d+1) % 4;
                x += dx[d];
                y += dy[d];
            }
            
        }
        
        return answer;
    }
}