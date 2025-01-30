import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열의 길이
        int S = Integer.parseInt(st.nextToken()); // 부분합

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while(right < N) {
            sum += arr[right];

            while(sum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left];
                left++;
            }
            right++;
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}