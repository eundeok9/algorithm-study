import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int left = 0;
        int right = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        long M = Integer.parseInt(br.readLine());
        while(left <= right) {
            int mid = (left + right) / 2;
            long money = 0;
            for(int i=0; i<N; i++) {
                if(mid < arr[i]) money += mid;
                else money += arr[i];
            }
            if(money > M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}
