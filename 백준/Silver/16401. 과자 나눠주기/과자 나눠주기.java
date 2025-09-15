import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] length = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(length);

        int left = 1, right = length[N-1];
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            for(int i=0; i<N; i++) {
                cnt += length[i] / mid;
            }

            if(cnt >= M) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(answer);
    }
}