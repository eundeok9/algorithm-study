import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0, end = 0;
        int minDiff = Integer.MAX_VALUE;
        while(start <= end && end < N) {
            if(arr[end]-arr[start] >= M) {
                minDiff = Math.min(arr[end]-arr[start], minDiff);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(minDiff);
    }
}