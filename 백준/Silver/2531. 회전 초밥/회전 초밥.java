import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N+k-1]; // 회전초밥 => k-1개만큼 연장해서 저장
        for(int i=0; i<N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for(int i=N; i<N+k-1; i++) {
            sushi[i] = sushi[i-N];
        }

        int[] count = new int[d+1];
        int kind = 0;

        for(int i=0; i<k; i++) {
            if(count[sushi[i]]++ == 0) kind++;
        }

        int max = kind + (count[c] == 0 ? 1 : 0);

        for(int i=1; i<N; i++) {
            // 앞에 하나 제거
            if(--count[sushi[i-1]] == 0) kind--;
            // 뒤에 하나 추가
            if(count[sushi[i+k-1]]++ == 0) kind++;

            int total = kind + (count[c] == 0? 1 : 0);
            max = Math.max(total, max);
        }

        System.out.println(max);
    }
}