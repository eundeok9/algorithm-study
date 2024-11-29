import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int rows = park.length;
        int cols = park[0].length;
        Arrays.sort(mats);
        
        for(int m = mats.length - 1; m>=0; m--) {
            int matSize = mats[m];
            
            for(int i=0; i<=rows-matSize; i++) {
                for(int j=0; j<=cols-matSize; j++) {
                    boolean isPossible = true;
                    
                    for(int x=i; x<i+matSize; x++) {
                        for(int y=j; y<j+matSize; y++) {
                            if(!park[x][y].equals("-1")) {
                                isPossible = false;
                                break;
                            }
                        }
                        if(!isPossible) break;
                    }
                    
                    if(isPossible) {
                        return matSize;
                    }
                }
            }
        }
        
        return answer;
    }
}