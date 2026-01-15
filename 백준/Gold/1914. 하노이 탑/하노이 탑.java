import java.io.*;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger count = BigInteger.ONE.shiftLeft(N).subtract(BigInteger.ONE);
        System.out.println(count);

        if(N <= 20) {
            hanoi(N, 1, 3, 2);
        }
    }

    static void hanoi(int n, int start, int dest, int via) {
        if(n<=1) {
            System.out.println(start + " " + dest);
            return;
        }

        hanoi(n-1, start, via, dest);
        System.out.println(start + " " + dest);
        hanoi(n-1, via, dest, start);
    }
}