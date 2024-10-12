import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        
        queue.add(new Integer[]{numbers[0], 0});
        queue.add(new Integer[]{-1*numbers[0], 0});
        
        while(!queue.isEmpty()) {
            Integer[] cur = queue.poll();
            int num = cur[0];
            int idx = cur[1];
            
            idx++;
            
            if(idx < numbers.length) {
                queue.add(new Integer[]{num+numbers[idx], idx});
                queue.add(new Integer[]{num-numbers[idx], idx});
            } else {
                if(target==num) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}