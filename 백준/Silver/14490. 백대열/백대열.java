import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(":");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);


        int g = gcd(a, b);

        a /= g;
        b /= g;

        System.out.println(a + ":" + b);
    }

    static int gcd(int x, int y) {
        while(y!=0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}