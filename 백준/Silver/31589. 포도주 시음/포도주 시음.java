import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] taste = new int[N];
        for(int i=0; i<N; i++) {
            taste[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(taste);

        long answer = taste[N-1];
        int idx1 = N-2, idx2 = 0, cnt = K-1;
        while(cnt > 1) {
            answer += taste[idx1--] - taste[idx2++];
            cnt -= 2;
        }

        System.out.println(answer);
    }
}