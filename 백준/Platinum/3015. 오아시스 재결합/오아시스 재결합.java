import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Stack<Node> stack = new Stack<>();
    static long cnt;

    public static class Node{
        int h, cnt;
        Node(int h, int cnt) {
            this.h = h;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        for(int i=0; i<N; i++) {
            int height = Integer.parseInt(br.readLine());
            Node cur = new Node(height, 1);

            while(!stack.isEmpty() && stack.peek().h <= height) {
                Node top = stack.pop();
                cnt += top.cnt;
                if(top.h == height) {
                    cur.cnt += top.cnt;
                }
            }

            if(!stack.isEmpty()) {
                cnt++;
            }
            stack.push(cur);
        }
        System.out.println(cnt);
    }
}
