import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=0; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<M; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if(start != parent[cur]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            if(a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

    static int find(int x) {
        if(x==parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}