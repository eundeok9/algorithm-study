import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Queue<Integer> buffer = new LinkedList<>();
        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n==-1) break;

            if(n==0) {
                buffer.poll();
            } else if (size > buffer.size()){
                buffer.offer(n);
            }
        }

        if(buffer.isEmpty()) {
            System.out.println("empty");
        } else {
            StringBuilder sb = new StringBuilder();
            for(int i: buffer) {
                sb.append(i + " ");
            }
            System.out.println(sb);
        }
    }
}