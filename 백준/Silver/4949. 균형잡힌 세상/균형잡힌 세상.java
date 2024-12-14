import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            Stack<String> stack = new Stack<>();
            String s = br.readLine();
            String answer = "yes";
            if(s.equals(".")) break;

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[') {
                    stack.push(String.valueOf(s.charAt(i)));
                } else if(s.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(")");
                    }
                } else if(s.charAt(i) == ']') {
                    if(!stack.isEmpty() && stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        stack.push("]");
                    }
                }
            }
            if(!stack.isEmpty()) {
                answer = "no";
            } else {
                answer = "yes";
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
