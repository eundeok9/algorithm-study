import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;
        int index1 = -1;
        int index2 = -1;
        long min = Long.MAX_VALUE;
        while(left < right) {
            long sum = nums[left] + nums[right];
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                index1 = left;
                index2 = right;
            }
            if(sum >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(nums[index1] + " " + nums[index2]);

    }
}
