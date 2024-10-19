import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<todo_list.length; i++) {
            if(!finished[i]) {
                list.add(todo_list[i]);
            }
        }
        
        String[] answer = list.toArray(new String[list.size()]);
        
        return answer;
    }
}