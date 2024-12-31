import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = 123456 * 2;
        boolean[] isPrime = new boolean[size + 1];
        int[] primeCount = new int[size+ 1];

        solve(isPrime);

        for(int i=1; i<=size; i++) {
            primeCount[i] = primeCount[i-1];
            if(isPrime[i]) primeCount[i]++;
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;

            sb.append(primeCount[2*n] - primeCount[n]).append("\n");
        }
        System.out.println(sb);
    }

    public static void solve(boolean[] isPrime) {
        int n = isPrime.length - 1;

        for(int i=2; i<=n; i++) {
            isPrime[i] = true;
        }

        for(int i=2; i*i<=n; i++) {
            if(isPrime[i]) {
                for(int j= i*i; j <=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}