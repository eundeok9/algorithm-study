import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for(int i=0; i<s.length(); i++) {
                for(int j=0; j<R; j++) {
                    sb.append(s.charAt(i));
                }
            }

            System.out.println(sb);
        }
    }
}