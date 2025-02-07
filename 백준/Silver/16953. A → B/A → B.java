import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        Queue<Long> queue = new LinkedList<>();
        queue.add(A * 2);
        queue.add(A * 10 + 1);

        int answer = 0;
        while(!queue.isEmpty()) {
            answer++;
            int size = queue.size();

            for(int i=0; i<size; i++) {
                long now = queue.poll();
                if(now > B) continue;
                if(now == B) {
                    System.out.println(answer + 1);
                    return;
                }
                queue.add(now * 2);
                queue.add(now * 10 + 1);
            }
        }

        System.out.println(-1);
    }
}