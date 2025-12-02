class Solution {
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static int N;
    public int[] solution(int[][] arr) {
        N = arr.length;
        
        dfs(0, 0, N, arr);
        
        return new int[] {zeroCnt, oneCnt};
    }
    
    static void dfs(int r, int c, int size, int[][] arr) {
        if(checkSame(r, c, size, arr)) {
            if(arr[r][c] == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
            
            return;
        }
        
        int half = size / 2;
        dfs(r, c, half, arr);
        dfs(r, c + half, half, arr);
        dfs(r + half, c, half, arr);
        dfs(r + half, c + half, half, arr);
    }
    
    static boolean checkSame(int r, int c, int size, int[][] arr) {
        int value = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != value) return false;
            }
        }
        return true;
    }
}