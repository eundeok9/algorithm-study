import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        answer = n - lost.length; // 도난당하지 않은 학생 수
        
        // 도난 당한 학생 중 여벌 체육복이 있는 학생
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1; // 빌림 체크
                    reserve[j] = -1; // 빌려줌 체크
                    break;
                }
            }
        }
        
        // 도난 당한 학생 중 체육복을 빌릴 수 있는 학생
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] -1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1; // 빌려줌 체크
                    break;
                }
            }
        }
        
        return answer;
    }
}