import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        if(K==1) {
            System.out.println(Integer.parseInt(br.readLine()) / N);
            return;
        }

        int[] arr = new int[K];
        long left = 1;
        long right = 0;
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i], right);
        }

        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for(int i=0; i<K; i++) {
                if(mid > 0) {
                    count += (arr[i] / mid);
                }
            }

            if(count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}