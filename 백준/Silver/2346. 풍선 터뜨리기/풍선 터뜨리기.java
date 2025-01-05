import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        int num = arr[0];

        for(int i=1; i<N; i++) {
            deque.add(new int[] {(i+1), arr[i]});
        }

        while(!deque.isEmpty()) {
            // 양수인 경우
            if(num > 0) {
                for(int i=1; i<num; i++) {
                    deque.add(deque.poll());
                }

                int[] next = deque.poll();
                num = next[1];
                sb.append(next[0] + " ");
            }

            else {
                for(int i=1; i<-num; i++) {
                    deque.addFirst(deque.pollLast());
                }

                int[] next = deque.pollLast();
                num = next[1];
                sb.append(next[0] + " ");
            }
        }
        System.out.println(sb);
    }
}