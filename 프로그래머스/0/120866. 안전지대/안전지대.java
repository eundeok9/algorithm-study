class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        int[][] board2 = new int[n][m];
        
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1) {
                    board2[i][j] = 1;
                    for(int d=0; d<8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if(nx<0||nx>=n||ny<0||ny>=m) continue;
                        
                        board2[nx][ny] = 1;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board2[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
}