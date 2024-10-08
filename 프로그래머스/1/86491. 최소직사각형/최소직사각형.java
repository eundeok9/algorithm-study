class Solution {
    public int solution(int[][] sizes) {
        int maxH = 0;
        int maxW = 0;
        for(int i=0; i<sizes.length; i++) {
            int curH = Math.min(sizes[i][0], sizes[i][1]);
            int curW = Math.max(sizes[i][0], sizes[i][1]);
            
            if(maxH < curH) {
                maxH = curH;
            }
            
            if (maxW < curW) {
                maxW = curW;
            }
        }
        
        return maxH * maxW;
    }
}