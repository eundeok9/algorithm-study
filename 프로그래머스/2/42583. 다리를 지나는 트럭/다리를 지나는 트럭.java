import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length; i++) {
            q.add(0);
        }
        
        int index = 0;
        int curWeight = 0;
        while(index < truck_weights.length) {
            curWeight -= q.poll();
            answer += 1;
            
            if(curWeight + truck_weights[index] <= weight) {
                curWeight += truck_weights[index];
                q.add(truck_weights[index++]);
            } else {
                q.add(0);
            }
        }
        return answer + bridge_length;
    }
}