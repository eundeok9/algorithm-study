class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int maxY = -256;
        int minY = 256;
        int maxX = -256;
        int minX = 256;
        
        for(int i=0; i<dots.length; i++) {
            int x = dots[i][0];
            int y = dots[i][1];
            if(x > maxX) {
                maxX = x;
            } else if(x <= minX) {
                minX = x;
            }
            if(y > maxY) {
                maxY = y;
            } else if(y <= minY) {
                minY = y;
            }
        }
        
        
        return (maxX-minX) * (maxY-minY);
    }
}