import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while(end < N) {
            sum += arr[end];
            while(sum >= S) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= arr[start];
                start++;
            }
            end++;
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}