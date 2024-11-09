import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String[] sarr = s.split("");
        Arrays.sort(sarr, Collections.reverseOrder());
        
        for(String str: sarr) {
            answer.append(str);
        }
        
        return answer.toString();
    }
}