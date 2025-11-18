import java.util.*;
class Solution {
    public int[] solution(String msg) {
        // 사전 초기화
        Map<String, Integer> dict = new HashMap<>();
        int nextIndex = 1;
        for(char c = 'A'; c<='Z'; c++) {
            dict.put(String.valueOf(c), nextIndex++);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int i = 0;
        while(i<msg.length()) {
            // 사전과 일치하는 가장 긴 문자열 w
            String w = "" + msg.charAt(i);
            while(i+1 < msg.length() && dict.containsKey(w+msg.charAt(i+1))) {
                w += msg.charAt(++i);
            }
            
            // 색인 번호
            answer.add(dict.get(w));
            
            // 신규 문자열 w+c 사전에 입력
            if(i+1<msg.length()) {
                String newWord = w + msg.charAt(i+1);
                if(!dict.containsKey(newWord)) {
                    dict.put(newWord, nextIndex++);
                }
            }
            
            i++;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}