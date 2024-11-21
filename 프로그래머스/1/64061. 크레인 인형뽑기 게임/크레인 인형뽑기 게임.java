import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int col: moves) {
            for(int i=0; i<board.length; i++) {
                if(board[i][col-1] != 0) {
                    if(!stack.isEmpty() && stack.peek() == board[i][col-1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.add(board[i][col-1]);
                    }
                    board[i][col-1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}