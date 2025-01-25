import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = gcd(a, b);

            sb.append(a * b / gcd).append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        while(b!=0) {
            int r = b;
            b = a % b;
            a = r;
        }
        return a;
    }
}