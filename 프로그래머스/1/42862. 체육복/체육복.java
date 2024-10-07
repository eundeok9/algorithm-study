import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 도난 당했는데 여분 체육복이 있을 때
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer += 1;
                    break;
                }
            }
        }
        
        // 도난 당했는데 여분 체육복 없을 때
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    reserve[j] = -1;
                    answer += 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}