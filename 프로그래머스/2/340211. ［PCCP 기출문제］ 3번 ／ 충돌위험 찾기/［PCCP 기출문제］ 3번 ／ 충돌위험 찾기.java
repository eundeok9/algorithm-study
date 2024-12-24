import java.util.*;

class Solution {
    
    static Queue<int[]>[] record;
    static int n; // 로봇의 개수
    static int answer;
    
    public int solution(int[][] points, int[][] routes) {
        n = routes.length;
        record = new LinkedList[n];
        
        for(int i=0; i<n; i++) {
            record[i] = new LinkedList<>();
        }
        
        recording(points, routes);
        
        count();
        
        return answer;
    }
    
    // 각 로봇의 경로 기록
    public static void recording(int[][] points, int[][] routes) {
        for(int i=0; i<n; i++) {
            int[] route = routes[i];
            int x = points[route[0] - 1][1];
            int y = points[route[0] - 1][0];
            
            record[i].add(new int[] {x, y});
            
            for(int j=1; j<route.length; j++) {
                int nx = points[route[j] - 1][1];
                int ny = points[route[j] - 1][0];
                
                while(ny != y) {
                    if(ny > y) y++;
                    else y--;
                    
                    record[i].add(new int[] {x, y});
                }
                
                while(nx != x) {
                    if(nx > x) x++;
                    else x--;
                    
                    record[i].add(new int[] {x, y});
                }
            }
        }
    }
    
    public static void count() {
        int cnt = 0; // 경로가 끝난 로봇의 수
        
        while(cnt < n) {
            int[][] map = new int[101][101];
            cnt = 0;
            
            for(int i=0; i<n; i++) {
                if(record[i].isEmpty()) { // 현재 로봇이 더이상 이동할 경로가 없다면
                    cnt++;
                    continue;
                }
                
                int[] tmp = record[i].poll();
                map[tmp[0]][tmp[1]]++; // 지나간 횟수 기록
            }
            
            for(int i=0; i<101; i++) {
                for(int j=0; j<101; j++) {
                    if(map[i][j] > 1) answer++; // 두 번 이상 지나간 곳 카운트
                }
            }
        }
    }
}