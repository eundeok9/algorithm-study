import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        isPrime = new boolean[1000001]; // 100만까지 소수인지 아닌지 메모이제이션
        Arrays.fill(isPrime,true);

        isPrime[0] = isPrime[1] = false;
        for(int i=2; i<=Math.sqrt(1000000); i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=1000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n==0) break;

            isGoldbach(n);
        }

        System.out.println(sb);
    }

    public static void isGoldbach(int n) {
        for(int i=3; i<=n; i++) {
            if(isPrime[i] && isPrime[n-i]) {
                sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
                return;
            }
        }

        sb.append("Goldbach's conjecture is wrong.").append("\n");
    }
}