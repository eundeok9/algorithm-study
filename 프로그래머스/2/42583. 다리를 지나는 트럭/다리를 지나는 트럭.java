import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<bridge_length; i++) {
            bridge.add(0); // 다리 길이만큼 0으로 채우기
        }
        
        int idx = 0; // 마지막으로 올라간 트럭 index
        int currentWeight = 0; // 현재 다리 위에 있는 트럭 무게
        
        // 트럭 개수만큼 반복
        while(idx < truck_weights.length) {
            currentWeight -= bridge.poll(); // 다리 끝에 도달한 트럭 무게 제거
            answer++; // 시간 1초 추가
            
            // 다리가 견딜 수 있는지 체크
            if(currentWeight + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0); // 견딜 수 없다면 다리에 0 추가
            }
        }
        
        return answer + bridge_length;
    }
}