import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        HashMap<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        int count = 1;
        for(int i=1; i<words.length; i++) {
            if(i%n == 0) {
                count++;
            }
            
            map.put(words[i], map.getOrDefault(words[i] , 0) + 1);
            
            if(words[i].length() == 1 || words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1) || map.get(words[i]) > 1) {
                System.out.println(words[i]);
                answer[0] = (i+1) % n != 0 ? (i+1) % n : n;
                answer[1] = count;
                break;
            }
        }

        return answer;
    }
}