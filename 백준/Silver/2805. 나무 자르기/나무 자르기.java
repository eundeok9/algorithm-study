import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, tree[i]);
        }

        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for(int i=0; i<N; i++) {
                if(tree[i] > mid) {
                    sum += (tree[i] - mid);
                }
            }

            if(sum >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}