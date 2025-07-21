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

        int[] answer = new int[3];
        long minSum = Long.MAX_VALUE;

        // 수 하나 정해놓고, 그 다음수부터 마지막 수까지 중에서 2개 고르는 이분탐색 수행
        for(int i=0; i<N-2; i++) {
            int left = i+1;
            int right = N-1;
            while(left < right) {
                long sum = (long) arr[left] + arr[i] + arr[right];

                if(sum == 0) {
                    System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                    return;
                }

                if(Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        for(int i=0; i<3; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}