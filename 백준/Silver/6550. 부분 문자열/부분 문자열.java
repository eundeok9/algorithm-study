import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            String S = st.nextToken();
            String T = st.nextToken();

            int idx = 0;
            for (int i = 0; i < T.length() && idx < S.length(); i++) {
                if (S.charAt(idx) == T.charAt(i)) {
                    idx++;
                }
            }

            if (idx == S.length()) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }
        System.out.print(sb);
    }
}