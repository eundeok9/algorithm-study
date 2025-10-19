import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] dp = new int[26][s.length()]; // 각 알파벳이 몇 번 나오는지 기록
        dp[s.charAt(0)-'a'][0] = 1;
        for(int i=1; i<s.length(); i++) {
            int alpha = s.charAt(i)-'a';
            for(int j=0; j<26; j++) {
                if(alpha == j) dp[j][i] = dp[j][i-1] + 1;
                else dp[j][i] = dp[j][i-1];
            }
        }

        while(q-->0) {
            st = new StringTokenizer(br.readLine());

            int alpha = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());


            if(l > 0) {
                sb.append(dp[alpha][r] - dp[alpha][l-1]).append("\n");
            } else {
                sb.append(dp[alpha][r]).append("\n");
            }
        }
        System.out.println(sb);
    }
}