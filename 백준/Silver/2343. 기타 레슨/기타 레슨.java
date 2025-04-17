import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 이분 탐색
        int left = 0;
        int right = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            if(left < arr[i]) {
                left = arr[i];
            }
        }

        while(left < right) {
            int mid = (left + right) / 2;

            int count = 1;
            int remain = mid;
            for(int i=0; i<N; i++) {
                if(remain < arr[i]) {
                    remain = mid;
                    count++;
                }
                remain -= arr[i];
            }

            if(count > M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }
}