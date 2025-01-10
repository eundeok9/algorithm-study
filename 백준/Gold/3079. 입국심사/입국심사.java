import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입국 심사대 수
        int M = Integer.parseInt(st.nextToken()); // 인원 수

        long[] arr = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long left = 1;
        long right = arr[N-1] * M;
        long answer = 0;

        while(left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for(int i=0; i<arr.length; i++)
                cnt += mid / arr[i]; // 각 심사대에서 처리할 수 있는 인원 수

            if(cnt < M) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
