import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = null;
        while((input = br.readLine()) != null) {
            int N = Integer.parseInt(input.trim());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] lis = new int[N];
            lis[0] = arr[0];
            int len = 1;
            for(int i=1; i<N; i++) {
                if(lis[len-1] < arr[i]) {
                    lis[len++] = arr[i];
                } else {
                    int idx = binarySearch(0, len-1, arr[i], lis);
                    lis[idx] = arr[i];
                }
            }
            System.out.println(len);
        }
    }

    public static int binarySearch(int left, int right, int target, int[] lis) {
        int mid;

        while(left < right) {
            mid = (left + right) / 2;

            if(lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}