import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 초기 순위를 {이름: 순위} 쌍으로 저장
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String call: callings) {
            int idx = map.get(call);
            String before = players[idx-1];
            
            players[idx-1] = call;
            players[idx] = before;
            
            map.put(call, idx-1);
            map.put(before, idx);
        }
        
        return players;
    }
}