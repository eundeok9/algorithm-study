import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long start = 1;
        long end = (long)times[times.length-1] * n;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            long cnt = 0;
            for(int i=0; i<times.length; i++) {
                cnt += mid / times[i];
            }
            if(cnt < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}