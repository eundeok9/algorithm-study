import java.util.*;

class Solution {
    static List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        
        dfs("",0);
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                return i;                
            }
        }
        
        return answer;
    }
    
    public static void dfs(String s, int order) {
        list.add(s);
        if(order == 5) return;
        for(int i=0; i<5; i++) {
            dfs(s+"AEIOU".charAt(i), order+1);
        }
    }
}