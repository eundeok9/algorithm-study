import java.util.*;
class Solution {
    static HashMap<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        
        for(int i=0; i<info.length; i++) {
            String[] p = info[i].split(" ");
            makeMap(p, "", 0);
        }
        
        for(String key: map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
    
        return answer;
    }
    
    static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int left = 0, right = list.size() -1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(list.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return list.size() - left;
    }
    
    static void makeMap(String[] p, String str, int cnt) {
        if(cnt == 4) {
            if(!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str,list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        
        makeMap(p, str+"-", cnt+1);
        makeMap(p, str+p[cnt], cnt+1);
    }
}