import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        if(N <= 3) {
            System.out.println(1);
        } else {
            long[] fibo = new long[N + 1];
            fibo[1] = fibo[2] = fibo[3] = 1;
            for(int i=4; i<=N; i++) {
                fibo[i] = fibo[i-3] + fibo[i-1];
            }
            System.out.println(fibo[N]);
        }
    }
}