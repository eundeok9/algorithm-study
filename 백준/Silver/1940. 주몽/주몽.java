import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int cnt = 0;

        int left = 0;
        int right = N-1;

        while(left < right) {
            int sum = arr[left] + arr[right];

            if(sum == M) {
                cnt++;
                left++;
                right--;
            } else if(sum < M) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(cnt);
    }
}