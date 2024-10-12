// dfs
import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int answer;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        answer = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>(); // 인접 리스트 배열 초기화
        }
        
        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        // 모든 연결 요소에 대해 간선 제거하면서 전력망 나누기
        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
            
            // v1, v2를 잇는 간선 제거
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            int cnt = dfs(1, visited); // 임의의 노드에서 연결된 노드 수 세기
            
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(diff, answer);
            
            // 제거했던 간선 다시 추가
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    public static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;
        
        for(int next: graph[v]) {
            if(!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
        
        return cnt;
    }
}