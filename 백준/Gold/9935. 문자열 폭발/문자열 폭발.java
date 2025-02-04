import java.io.*;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s = br.readLine();
        String bomb = br.readLine();
        int bLength = bomb.length();

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));

            if(stack.size() >= bLength) {
                boolean flag = true;

                for(int j=0; j<bLength; j++) {
                    if(stack.get(stack.size() - bLength + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int j=0; j<bLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for(char ch: stack) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}