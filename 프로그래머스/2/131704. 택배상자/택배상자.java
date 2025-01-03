import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i=1; i<=order.length; i++) {
            stack.push(i);
            while(!stack.isEmpty()) {
                if(stack.peek() == order[index]) {
                    stack.pop();
                    index++;
                    answer++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}