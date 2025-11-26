import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(String r: record) {
            String[] arr = r.split(" ");
            
            if(arr[0].equals("Enter") || arr[0].equals("Change")) {
                map.put(arr[1], arr[2]);
            }
        }
        
        for(String r: record) {
            String[] arr = r.split(" ");
            String name = map.get(arr[1]);
            
            if(arr[0].equals("Enter")) {
                result.add(name+"님이 들어왔습니다.");
            } else if(arr[0].equals("Leave")) {
                result.add(name+"님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
           
        return answer;
    }
}