import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        long[] fact = new long[n+1];
        
        fact[0] = 1;
        for(int i=1; i<=n; i++) {
            fact[i] = fact[i-1] * i;
        }
        
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            nums.add(i);
        }
        
        int[] answer = new int[n];
        
        k--;
        
        for(int i=n; i>=1; i--) {
            long f = fact[i-1];
            int idx = (int) (k/f);
            answer[n-i] = nums.remove(idx);
            k %= f;
        }
        
        return answer;
    }
}