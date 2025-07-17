import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[N+1];
        List<Integer> primes = new ArrayList<>();
        isNotPrime[0] = isNotPrime[1] = true;

        // 에라토스테네스
        for(int i=2; i<=N; i++) {
            if(!isNotPrime[i]) {
                primes.add(i);
                for(int j=i*2; j<=N; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int count = 0, sum = 0;
        int start = 0, end = 0;

        while(true) {
            if(sum >= N) { // N보다 커지면 첫번째 수 빼기
                sum -= primes.get(start++);
            } else if(end == primes.size()) {
                break;
            } else { // N보다 작으면 다음 수 계속 더하기
                sum += primes.get(end++);
            }
            if(sum == N) count++;
        }

        System.out.println(count);
    }
}