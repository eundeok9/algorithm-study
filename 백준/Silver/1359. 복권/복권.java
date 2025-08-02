import java.io.*;
import java.util.*;
public class Main {
    static int N, M, K;
    static double prob;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        prob = 0.0;
        for(int i=K; i<=M; i++) {
            prob += (combination(M, i) * combination(N-M, M-i));
        }

        System.out.println(prob / combination(N, M));
    }

    public static double combination(int n, int r) {
        double result = 1;

        for(int i=0; i<r; i++) {
            result *= (n-i);
            result /= (i+1);
        }

        return result;
    }
}