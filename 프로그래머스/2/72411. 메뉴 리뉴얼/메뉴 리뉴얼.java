import java.util.*;

class Solution {
    static ArrayList<String> answer = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        // orders 오름차순 정렬
        for(int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for(int num: course) {
            for(String order: orders) {
                combi("", order, num, 0, 0);
            }
            
            if(!map.isEmpty()) {
                List<Integer> count = new ArrayList<>(map.values());
                int max = Collections.max(count);
                if(max < 2) continue;
                for(String key: map.keySet()) {
                    if(max == map.get(key)) {
                        answer.add(key);
                    }
                }
            }
            map.clear();
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    public static void combi(String s, String order, int num, int depth, int start) {
        if(num == depth) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        
        for(int i=start; i<order.length(); i++) {
            combi(s + order.charAt(i), order, num, depth+1, i+1);
        }
    }
}