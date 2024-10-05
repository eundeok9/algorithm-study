import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int num: nums) {
            hashSet.add(num);
        }
        
        int size = hashSet.size();
        
        if(size < answer) {
            answer = size;
        }
        
        return answer;
    }
}