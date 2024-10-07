import java.util.*;

class Solution {
    public TreeSet<Integer> solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        
        Arrays.sort(numbers);
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        return set;
    }
}