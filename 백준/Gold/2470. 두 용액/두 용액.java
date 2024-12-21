import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] nums = new long[N];
        for(int i=0; i<N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);

        int left = 0;
        int right = N-1;
        long minDiff = Long.MAX_VALUE;
        long[] answer = new long[2];
        while(left<right) {
            long sum = nums[left] + nums[right];

            if(minDiff > Math.abs(sum)) {
                minDiff = Math.abs(sum);
                answer[0] = nums[left];
                answer[1] = nums[right];
                
                if(sum == 0) break;
            }

            if(sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
