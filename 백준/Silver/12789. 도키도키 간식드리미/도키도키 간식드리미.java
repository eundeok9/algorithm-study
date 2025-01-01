import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int cur = 1;
        for(int i=0; i<N; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
            while(!stack.isEmpty()) {
                if(stack.peek() == cur) {
                    cur++;
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}