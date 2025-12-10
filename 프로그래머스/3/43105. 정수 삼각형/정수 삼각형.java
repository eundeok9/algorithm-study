class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int height = triangle.length;
        int[][] dp = new int[height][height];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<height; i++) {
            for (int j=0; j<=i; j++) {
                if(j-1 < 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j >= i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
                
            }
        }
        
        for(int j=0; j<height; j++) {
            answer = Math.max(dp[height-1][j], answer);
        }
        
        return answer;
    }
}