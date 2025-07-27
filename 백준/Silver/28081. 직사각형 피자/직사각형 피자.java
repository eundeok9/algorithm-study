import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        long[] hCuts = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            hCuts[i] = Long.parseLong(st.nextToken());
        }

        long[] blockH = new long[N+1];
        blockH[0] = hCuts[0];                    // 첫 조각
        for (int i = 1; i <= N; i++) {
            long hi = (i < N) ? hCuts[i] : H;
            long lo = hCuts[i-1];
            blockH[i] = hi - lo;
        }

        int M = Integer.parseInt(br.readLine());
        long[] wCuts = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            wCuts[i] = Long.parseLong(st.nextToken());
        }

        long[] blockW = new long[M+1];
        blockW[0] = wCuts[0];

        for (int i = 1; i <= M; i++) {
            long hi = (i < M) ? wCuts[i] : W;
            long lo = wCuts[i-1];
            blockW[i] = hi - lo;
        }
        Arrays.sort(blockW);

        long answer = 0;
        for(long h: blockH) {
            if(h==0) continue;
            long t = K / h;
            answer += upperBound(blockW, t); // K/h보다 작거나 같은 W의 개수
        }
        System.out.println(answer);
    }

    static int upperBound(long[] a, long key) {
        int lo = 0, hi = a.length;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(a[mid] <= key) lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}