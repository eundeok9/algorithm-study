import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] road; // 거리
    static int[] cost; // 비용

    static long sum;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(sum);
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        road = new int[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        sum = 0;
        long minCost = cost[0]; // 이전까지 과정 중 최소 비용

        for(int i=0; i<N-1; i++) {
            if(cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += (minCost * road[i]);
        }
    }
}
