import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static long[] dp, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N];
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int len = 1; // LIS 길이
        for(int i=1; i<N; i++) {
            if(dp[len-1] < arr[i]) {
                dp[len++] = arr[i];
            } else {
                int idx = binarySearch(0, len-1, arr[i]);
                dp[idx] = arr[i];
            }
        }
        System.out.println(len);
    }

    public static int binarySearch(int left, int right, long target) {
        int mid;

        while(left < right) {
            mid = (left + right) / 2;

            if(dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
