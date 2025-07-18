import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int[] count = new int[max+1];
        long answer = 0L;
        int left = 0, right = 0;
        while(left < N) {
            while(right < N && count[arr[right]] == 0) {
                count[arr[right]]++;
                right++;
            }

            answer += right - left;

            count[arr[left]]--;
            left++;
        }

        System.out.println(answer);
    }
}