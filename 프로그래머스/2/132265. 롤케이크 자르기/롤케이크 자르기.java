import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        int[] left = new int[topping.length];
        for(int i=0; i<topping.length; i++) {
            set.add(topping[i]);
            left[i] = set.size();
        }
        
        set.clear();
        int[] right = new int[topping.length];
        for(int i=topping.length-1; i>=0; i--) {
            set.add(topping[i]);
            right[i] = set.size();
        }
        
        for(int i=0; i<topping.length-1; i++) {
            if(left[i] == right[i+1]) {
                answer++;
            }
        }
        
        return answer;
    }
}