import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(a[i] == 0) {
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(M-->0) {
            int x = Integer.parseInt(st.nextToken());

            deque.addFirst(x);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}