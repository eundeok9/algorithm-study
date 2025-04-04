class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        String color = board[h][w];
        int n = board.length;
        
        for(int d=0; d<4; d++) {
            int nx = h + dx[d];
            int ny = w + dy[d];
            if(check(nx, ny, n) && board[nx][ny].equals(color)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(int x, int y, int n) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}