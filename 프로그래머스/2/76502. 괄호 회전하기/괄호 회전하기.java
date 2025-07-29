import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] carr = new char[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            carr[i] = s.charAt(i);
        }
        
       
        for(int i=0; i<s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            
            boolean flag = true;
            for(int j=i; j<i+s.length(); j++) {
                char ch = carr[j % s.length()];
                if(ch == '[' || ch == '{' || ch == '(') {
                    stack.push(ch);
                } else if(ch == ']') {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }
                } else if(ch == '}') {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if(!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }
                } else if(ch == ')') {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && flag) {
                answer++;
            }
        }
        
        return answer;
    }
}