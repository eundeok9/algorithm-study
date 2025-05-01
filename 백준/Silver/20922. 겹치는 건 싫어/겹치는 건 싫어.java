import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];
        int start = 0;
        int end = 0;
        int answer = 0;
        while(end < N) {
            while(end < N && cnt[arr[end]] + 1 <= K) {
                cnt[arr[end++]]++;
            }
            answer = Math.max(answer, end - start);
            cnt[arr[start++]]--;
        }
        System.out.println(answer);
    }
}