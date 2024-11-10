import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        String[] sarr = s.split("");
        for(int i=0; i<sarr.length; i++) {
            if(map.containsKey(sarr[i])) {
                answer.add(i - map.get(sarr[i]));
            } else {
                answer.add(-1);
            }
            map.put(sarr[i], i);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}