import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            int count = arr[2];
            
            if(x == maps.length-1 && y == maps[0].length-1) {
                return count;
            }
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1) {
                    continue;
                }
                
                if(!visited[nx][ny] && maps[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,count+1});
                }
            }
        }
        
        return -1;
        
    }
}