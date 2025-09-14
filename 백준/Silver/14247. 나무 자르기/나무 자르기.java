import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        for(int i=0; i<N; i++) {
            answer += Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] growth = new int[N];
        for(int i=0; i<N; i++) {
            growth[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(growth);
        for(int i=0; i<N; i++) {
            answer += (long) growth[i] * i;
        }
        System.out.println(answer);
    }
}