import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> answer = new ArrayList<>();
        
        for(int num: numlist) {
            answer.add(num);
        }
            
        Collections.sort(answer, (o1, o2) -> {
            int diff1 = Math.abs(o1 - n);
            int diff2 = Math.abs(o2 - n);
            
            if (diff1 == diff2) {
                return o2 - o1;
            } else {
                return diff1 - diff2;
            }
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}