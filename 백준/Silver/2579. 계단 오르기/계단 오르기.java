import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[0] = 0;
        for(int i=1; i<=N; i++) {
            if(i==1) {
                dp[i] = arr[i];
            } else if(i==2) {
                dp[i] = arr[i] + arr[i-1];
            } else{
                dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
            }
        }

        System.out.println(dp[N]);
    }
}