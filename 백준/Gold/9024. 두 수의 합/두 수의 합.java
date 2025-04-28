import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int left = 0;
            int right = arr.length - 1;
            int best = (int)(2 * 10e8);
            int count = 1;

            while(left < right) {
                int sum = arr[left] + arr[right];
                if(Math.abs(sum - k) == best) {
                    count++;
                } else if(Math.abs(sum - k) < best) {
                    count = 1;
                    best = Math.abs(sum - k);
                }

                if(sum == k) {
                    left++;
                    right--;
                } else if(sum < k) {
                    left++;
                } else {
                    right--;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
