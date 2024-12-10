import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(true) {
            if(pq.size() == 1) {
                System.out.println(answer);
                return;
            }

            int newNum = pq.poll() + pq.poll();
            answer += newNum;
            pq.add(newNum);
        }

    }
}
