import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] count = new int[100001];
        int start = 0;
        int end = 0;
        int answer = Integer.MIN_VALUE;
        
        while(end < N) {
            // 늘릴 수 있으면 end 증가
            while(end < N && count[numbers[end]] + 1 <= K) {
                count[numbers[end++]]++;
            }
            
            // 늘릴 수 없음
            int len = end - start;
            answer = Math.max(answer, len);
            
            count[numbers[start++]]--;
        }
        
        System.out.println(answer);
        
    }
}