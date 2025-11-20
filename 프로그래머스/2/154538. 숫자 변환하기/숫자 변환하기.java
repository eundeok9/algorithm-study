import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        int[] visited = new int[1000001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            if(cur == y) return visited[cur];
            
            for(int next: new int[] {cur*3, cur*2, cur+n}) {
                if(next < 0 || next > 1000000) continue;
                if(visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    queue.offer(next);
                }
            }  
        }
        
        return answer;
    }
}

// x -> y
// x + n or x * 2 or x * 3

// 불가능하다면 -1

