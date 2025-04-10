import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        cost = new int[N+1];

        // 자기 자신을 부모로 초기화
        for(int i=1; i<=N; i++) parent[i] = i;

        // 친구비 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        // 친구 관계 처리
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        int[] minCost = new int[N+1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        for(int i=1; i<=N; i++) {
            int root = find(i);
            minCost[root] = Math.min(minCost[root], cost[i]);
        }

        int total = 0;
        for(int i=1; i<=N; i++) {
            if(parent[i] == i) {
                total += minCost[i];
            }
        }

        if (total > K) System.out.println("Oh no");
        else System.out.println(total);
    }

    // 경로 압축을 포함한 find
    static int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    // 친구 그룹 통합
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa != pb) {
            parent[pb] = pa;
        }
    }
}