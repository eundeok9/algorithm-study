import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int start = 0;
        int end = 0;
        int answer = 0;

        while(end < n) {
            while(end < n && count[arr[end]] + 1 <= k) {
                count[arr[end++]]++;
            }
            int len = end - start;
            answer = Math.max(len, answer);
            count[arr[start++]]--;
        }

        System.out.println(answer);
    }
}