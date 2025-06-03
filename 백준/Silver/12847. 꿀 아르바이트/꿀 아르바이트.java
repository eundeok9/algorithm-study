import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M == 0) {
            System.out.println(0);
            return;
        }

        long[] sum = new long[N];

        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + num;
        }

        long max = sum[M-1];
        for(int i=M; i<N; i++) {
            max = Math.max(max, sum[i]-sum[i-M]);
        }
        System.out.println(max);
    }
}