import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        int minLIS = 1;
        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            minLIS = Math.max(minLIS, dp[i]);
        }

        System.out.println(minLIS);
    }
}
