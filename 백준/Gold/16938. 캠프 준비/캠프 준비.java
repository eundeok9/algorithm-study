import java.io.*;
import java.util.*;
public class Main {
    static int N, L, R, X;
    static int[] arr;
    static int answer;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println(answer);
    }

    public static void backTracking(int start, int cnt, int sum, int max, int min) {
        if(cnt >= 2) {
            if (L <= sum && sum <= R && max - min >= X) {
                answer++;
            }
        }

        for(int i=start; i<N; i++) {
            backTracking(i+1, cnt+1, sum+arr[i], Math.max(max, arr[i]), Math.min(min, arr[i]));
        }
    }
}