import java.util.*;
class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        map = new int[rows+1][columns+1];
        int num = 1;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                map[i][j] = num++;
            }
        }
        
        int index = 0;
        for(int[] query: queries) {
            int min = Integer.MAX_VALUE;
            
            for(int i=query[0]; i<=query[2]; i++) {
                if(i == query[0] || i ==query[2]) {
                    for(int j=query[1]; j<=query[3]; j++) {
                        min = Math.min(map[i][j], min);
                    }
                } else {
                    min = Math.min(min, Math.min(map[i][query[1]], map[i][query[3]]));
                }
            }
            
            answer[index++] = min;
            
            // query가 1개면 굳이 회전할 필요 없음
            if(queries.length == 1) continue;
            
            rotate(query[0], query[1], query[2], query[3], rows, columns);
        }
        
        
        return answer;
    }
    
    static void rotate(int x1, int y1, int x2, int y2, int rows, int cols) {
        int[][] tmpMap = new int[rows+1][cols+1];
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int x = x1, y = y1+1, d = 0;
        while(true) {
            x += dx[d];
            y += dy[d];
            
            if(x < x1 || x > x2 || y < y1 || y > y2) {
                x -= dx[d];
                y -= dy[d];
                d = (d+1) % 4;            
                x += dx[d];
                y += dy[d];
            }
            
            if(tmpMap[x][y] != 0) break;
            
            tmpMap[x][y] = map[x-dx[d]][y-dy[d]];
        }
        
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                if(tmpMap[i][j] != 0) map[i][j] = tmpMap[i][j];
            }
        }
        
    }
}

// 그냥 그 테두리에서 최솟값 찾는거 아닌가?
// 회전에 의해 숫자 위치가 안바뀔 수가 있음?

// [2, 2, 5, 4]
// 선택되는 값들
// [2][2], [2][3], [2][4]
// [3][2],         [3][4]
// [4][2],         [4][4]
// [5][2], [5][3], [5][4]

// i가 queries[0] 혹은 queries[2]와 같을 때는 j를 queries[1]~queries[3]까지 탐색
// 아닐 때는 j를 queries[1]과 queries[3]만 탐색