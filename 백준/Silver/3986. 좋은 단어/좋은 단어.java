import java.io.*;
import java.util.*;
public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        count = 0;
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            checkGoodWord(s);
        }
        System.out.println(count);
    }

    static void checkGoodWord(String s) {
        if(s.length() % 2 == 1) return;

        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            if(stack.size() > 0 && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()) count++;
    }
}