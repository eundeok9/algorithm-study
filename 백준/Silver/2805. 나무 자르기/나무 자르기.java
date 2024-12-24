import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long[] tree = new long[N];
        long min = 1;
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        long answer = 0;
        while(min <= max) {
            long mid = (min + max) / 2;

            long length = 0;
            for(int i=0; i<N; i++) {
                if(mid < tree[i]) {
                    length += tree[i] - mid;
                }
            }

            if(length >= M) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
