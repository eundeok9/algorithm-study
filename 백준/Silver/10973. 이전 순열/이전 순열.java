import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if(nextPermutation()) {
            for(int i=0; i<N; i++) {
                System.out.print(nums[i] + " ");
            }
        } else {
            System.out.print(-1);
        }

    }

    public static boolean nextPermutation() {
        int i = nums.length - 1;
        while(i>0 && nums[i-1] <= nums[i]) {
            i--;
        }
        if(i<=0) {
            return false;
        }
        int j = nums.length - 1;
        while(nums[j] >= nums[i-1]) {
            j--;
        }
        swap(i-1, j);
        j = nums.length - 1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    public static void swap(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
