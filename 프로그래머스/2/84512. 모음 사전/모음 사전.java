import java.util.*;

class Solution {
    static List<String> list;
    static String[] moeum = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("",0);
        int size = list.size();
        for(int i=0; i<size; i++) {
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
            dfs(s+moeum[i], order+1);
        }
    }
}