import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine()); // M, N, x, y
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int lcm = lcm(M, N); // 최소공배수 계산
            boolean flag = false;

            for(int k=X; k<=lcm; k+=M) {
                int modY = (k%N == 0) ? N : k % N;
                if(modY == Y) {
                    sb.append(k).append("\n");
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        while(b!=0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}