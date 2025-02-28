import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        for(int i=0; i<N; i++) {
            int target = arr[i];
            int left = 0, right = N-1;

            while(left < right) {
                if(left == i) {
                    left++;
                    continue;
                }

                if(right == i) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if(sum == target) {
                    answer++;
                    break;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        System.out.println(answer);
    }
}