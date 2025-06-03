import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] sum = new long[n];

        sum[0] = Integer.parseInt(br.readLine());
        for(int i=1; i<n; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(br.readLine());
        }

        long max = sum[m-1];
        for(int i=m; i<n; i++) {
            max = Math.max(max, sum[i] - sum[i-m]);
        }
        System.out.println(max);
    }
}