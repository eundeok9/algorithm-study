import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] lis, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lis = new int[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 1;
        lis[0] = arr[0];
        for(int i=1; i<N; i++) {
            if(lis[len-1] > arr[i]) {
                lis[len++] = arr[i];
            } else {
                int idx = binarySearch(0, len-1, arr[i]);
                lis[idx] = arr[i];
            }
        }
        
        System.out.println(len);
    }

    public static int binarySearch(int left, int right, int target) {
        int mid;

        while(left < right) {
            mid = (left + right) / 2;

            if(lis[mid] > target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
