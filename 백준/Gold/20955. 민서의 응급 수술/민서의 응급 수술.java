import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        int cycleCount = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(!union(u, v)) {
                cycleCount++;
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=N; i++) {
            set.add(find(i));
        }

        int componentCount = set.size();

        System.out.println(cycleCount + (componentCount - 1));
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[a] = b;
            return true;
        }

        return false;
    }
}