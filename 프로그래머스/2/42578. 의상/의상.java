import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        if(map.size() < 2) {
            return clothes.length;
        } else {
            for(Integer num: map.values()) {
                answer *= (num+1);
            }
        }
        
        return answer - 1;
    }
}