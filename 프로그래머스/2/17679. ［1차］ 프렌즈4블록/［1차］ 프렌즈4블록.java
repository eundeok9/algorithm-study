import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while(true) {
            boolean flag = true;
            boolean[][] check = new boolean[m][n];
            
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    if(map[i][j] == '-') {
                        continue;
                    }
                
                    char a = map[i][j];
                    if(map[i][j+1]==a&&map[i+1][j]==a&&map[i+1][j+1]==a) {
                        check[i][j] = true;
                        check[i+1][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                        flag = false;
                    }
                }
            }
            
            if(flag) break;
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(check[i][j]) {
                        map[i][j] = '-';
                        answer++;
                    }
                }
            }
            
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == '-') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != '-') {
                                map[i][j] = map[k][j];
                                map[k][j] = '-';
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}