import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if(n<0) { // 병사가 소진 됐을 때
                if(k>0 && !pq.isEmpty()) {
                    n += pq.poll(); // 가장 많은 병사의 수 꺼내서 무적권 쓰기
                    k--;
                    continue;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}