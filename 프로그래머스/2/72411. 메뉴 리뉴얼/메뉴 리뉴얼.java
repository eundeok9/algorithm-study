import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i=0; i<orders.length; i++) {
            char[] carr = orders[i].toCharArray();
            Arrays.sort(carr);
            orders[i] = String.valueOf(carr);
        }
        
        for(int num: course) {
            map = new HashMap<>();
            for(String order: orders) {
                combination(0, 0, num, "", order);
            }
            
            if(!map.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>(map.values());
                int max = Collections.max(list);
                if(max >= 2) {
                    for(String key: map.keySet()) {
                        if(map.get(key) == max) {
                            answer.add(key);
                        }
                    }
                }
            }
        }
        Collections.sort(answer);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    public static void combination(int depth, int start, int num, String s, String order) {
        if(depth == num) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        
        for(int i=start; i<order.length(); i++) {
            combination(depth + 1, i + 1, num, s + order.charAt(i), order);
        }
    }
}