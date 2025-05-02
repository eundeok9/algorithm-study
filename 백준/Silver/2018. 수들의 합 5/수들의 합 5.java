import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1, end = 1, sum = 1, count = 0;

        while(start <= N) {
            if(sum == N) count++;

            if(sum >= N) {
                sum -= start++;
            } else {
                end++;
                sum += end;
            }
        }

        System.out.println(count);
    }
}