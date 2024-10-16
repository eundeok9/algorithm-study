import java.util.*;

class Solution {
    static boolean[] visited;
    ArrayList<String> allRoute = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", 0, tickets); // 출발 공항, 거쳐온 경로, 거쳐온 공항 수, 항공권 정보
        
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(String start, String route, int cnt, String[][] tickets) {
        if(cnt == tickets.length) {
            allRoute.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], cnt + 1, tickets);
                visited[i] = false;
            }
        }
    }
}