import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer> graph;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new ArrayList<>();
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int[][] computers, int index) {
        visited[index] = true;
        
        for(int i=0; i<computers.length; i++) {
            if(i!=index && !visited[i] && computers[index][i] == 1) {
                dfs(computers, i);
            }
        }
    }
}