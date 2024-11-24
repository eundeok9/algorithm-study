import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<type.length; i++) {
            map.put(type[i], 0);
        }
        
        for(int i=0; i<survey.length; i++) {
            if(choices[i] == 4) {
                continue;
            }
            
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);
            
            if(choices[i] < 4) {
                map.put(left, map.get(left) + 4 - choices[i]);
            } else {
                map.put(right, map.get(right) + choices[i] - 4);
            }
        }
        
        for(int i=0; i<type.length; i+=2) {
            int left = map.get(type[i]);
            int right = map.get(type[i+1]);
            
            if(left >= right) {
                answer.append(type[i]);
            } else {
                answer.append(type[i+1]);
            }
        }
        
        return answer.toString();
    }
}