import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        int date = getDate(today);
        
        // 약관 종류, 유효기간 저장
        for(String term: terms) {
            String[] sarr = term.split(" ");
            map.put(sarr[0], Integer.parseInt(sarr[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            
            if(getDate(privacy[0]) + (map.get(privacy[1]) * 28) <= date) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        
        return year * 12 * 28 + month * 28 + day;
    }
}