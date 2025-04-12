import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd == 0) {
                union(a, b);
            } else {
                if(find(a) == find(b)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static int find(int x) {
        if(parent[x] != x) return parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa!=pb) {
            parent[pb] = pa;
        }
    }
}