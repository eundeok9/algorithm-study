import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int[][] dist = new int[n+1][n+1];
        for(int i=0; i<results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            
            dist[a][b] = 1;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                cnt += dist[i][j] + dist[j][i];
            }
            
            if(cnt == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}