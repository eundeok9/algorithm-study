import java.io.*;
public class Main {
    static int num1, num2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        System.out.println(num1 + " " + num2);
    }

    public static int fib(int n) {
        if(n==1 || n==2) {
            num1++;
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int fibonacci(int n) {
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 1;
        for(int i=3; i<=n; i++) {
            num2++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
