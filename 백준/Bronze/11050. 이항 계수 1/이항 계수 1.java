import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        K = Math.min(N - K, K);
        int init1 = 1;
        int init2 = 1;
        while(K > 0) {
            init1 *= N;
            N--;
            init2 *= K;
            K--;
        }
        System.out.println(init1 / init2);

    }
}
