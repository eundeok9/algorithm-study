import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] nums = Long.toString(n).split("");
        Arrays.sort(nums, (o1, o2) -> o2.compareTo(o1));
        
        StringBuilder sb = new StringBuilder();
        for(String num: nums) {
            sb.append(num);
        }
        
        return Long.parseLong(sb.toString());
    }
}