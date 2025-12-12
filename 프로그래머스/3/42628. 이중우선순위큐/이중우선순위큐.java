import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순 정렬
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // 오름차순 정렬
        
        for(String operation: operations) {
            String[] sp = operation.split(" ");
            
            int num = Integer.parseInt(sp[1]);
            
            if(sp[0].equals("I")) {
                maxQueue.add(num);
                minQueue.add(num);
            } else if(sp[0].equals("D") && !maxQueue.isEmpty()) {
                if(num == 1) {
                    minQueue.remove(maxQueue.poll());
                } else {
                    maxQueue.remove(minQueue.poll());
                }
            }
        }
        
        if(maxQueue.isEmpty()) return new int[] {0, 0};
        
        return new int[] {maxQueue.poll(), minQueue.poll()};
    }
}