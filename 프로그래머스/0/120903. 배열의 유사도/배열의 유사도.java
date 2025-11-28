import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        HashSet<String> set = new HashSet<>();
        for(String s: s1) {
            set.add(s);    
        }
        
        for(String s: s2) {
            if(set.contains(s)) {
                answer++;
            }
        }
        
        return answer;
    }
}