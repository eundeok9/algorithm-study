import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] needDays = new int[progresses.length];
        for(int i=0; i<progresses.length; i++) {
            if((100-progresses[i]) % speeds[i] != 0) {
                needDays[i] += 1;
            }
            needDays[i] += ((100-progresses[i]) / speeds[i]);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        int prevWork = needDays[0];
        int work = 1;
        for(int i=1; i<needDays.length; i++) {
            if(prevWork < needDays[i]) {
                answer.add(work);
                prevWork = needDays[i];
                work = 1;
            } else {
                work += 1;
            }
        }
        answer.add(work);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}