class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
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
            if(i != index && computers[index][i] == 1 && visited[i] == false) {
                dfs(computers, i);
            }
        }
    }
}