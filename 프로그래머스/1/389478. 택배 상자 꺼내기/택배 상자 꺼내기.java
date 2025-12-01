class Solution {
    static int[] dy = {1, -1};
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int h = (n + w - 1) / w;
        int[][] map = new int[h][w];
        
        int cur = 1;
        int curX = h-1;
        int curY = 0;
        int d = 0;
        
        int numX = -1;
        int numY = -1;
        while(true) {
            if(cur > n) break;
            if(cur == num) {
                numX = curX;
                numY = curY;
            }
            
            map[curX][curY] = cur++;
            
            curY += dy[d];
            
            if(curY < 0 || curY >= w) {
                curY -= dy[d];
                curX -= 1;
                d = (d+1)%2;
            }
        }
        
        while(numX >= 0 && map[numX][numY] != 0) {
            answer++;
            numX--;
        }
        
        return answer;
    }
}