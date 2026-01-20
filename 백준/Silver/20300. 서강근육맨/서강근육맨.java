import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = 0;
        if(N%2==0) {
            for(int i=0; i<N/2; i++) {
                long sum = arr[i] + arr[N-1-i];
                answer = Math.max(sum, answer);
            }
        } else {
            answer = arr[N-1];
            for(int i=0; i<(N-1)/2; i++) {
                long sum = arr[i] + arr[N-2-i];
                answer = Math.max(sum, answer);
            }
        }

        System.out.println(answer);
    }
}