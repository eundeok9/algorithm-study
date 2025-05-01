import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] alpha = new int[26];
        int start = 0;
        int end = 0;
        int cnt = 0;
        int answer = 0;

        while(end < s.length()) {
            int idx = s.charAt(end) - 'a';
            if(alpha[idx] == 0) cnt++;
            alpha[idx]++;
            end++;

            while(cnt > N) {
                int startIdx = s.charAt(start) - 'a';
                alpha[startIdx]--;
                if(alpha[startIdx] == 0) cnt--;
                start++;
            }

            answer = Math.max(answer, end-start);
        }

        System.out.println(answer);
    }
}