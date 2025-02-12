import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N+1];

        int count = 0;
        for(int i=2; i<=N; i++) {
            for(int j=i; j<=N; j+=i) {
                if(!check[j]) {
                    count++;
                    check[j] = true;
                }

                if(count == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}