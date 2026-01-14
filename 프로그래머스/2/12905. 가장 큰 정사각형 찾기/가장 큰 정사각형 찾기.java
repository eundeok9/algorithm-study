class Solution
{
    public int solution(int [][]board)
    {
        int N = board.length;
        int M = board[0].length;
        
        int max = 0;
        
        int[][] dp = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 1) {
                    if(i==0 || j==0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                }
                
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max*max;
    }
}