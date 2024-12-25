import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        dp[0] = arr[0];
        int i = 1;
        while(i < N) {
            // LIS 배열의 맨 뒤의 값보다 arr[i]가 더 크면, 그것을 LIS 배열의 맨 뒤에 추가
            if(dp[j] < arr[i]) {
                dp[++j] = arr[i];
            }
            // arr[i] 값이 더 작으면, arr[i]가 LIS 배열 중 어느 곳에 들어갈 수 있는지 이분 탐색
            else {
                int idx = binarySearch(0, j, arr[i]);
                dp[idx] = arr[i];
            }
            i++;
        }
        System.out.println(j+1);
    }

    public static int binarySearch(int left, int right, int target) {
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
