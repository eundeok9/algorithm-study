import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;

            parents = new int[N+1];
            for(int i=1; i<=N; i++) {
                parents[i] = i;
            }

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            Set<Integer> treeSet = new HashSet<>();
            for(int i=1; i<=N; i++) {
                int root = find(i);
                if(root > 0) {
                    treeSet.add(root);
                }
            }

            int treeNum = treeSet.size();
            if(treeNum == 0) {
                sb.append("Case ").append(idx++).append(": ").append("No trees.\n");
            } else if(treeNum == 1) {
                sb.append("Case ").append(idx++).append(": ").append("There is one tree.\n");
            } else {
                sb.append("Case ").append(idx++).append(": ").append("A forest of ").append(treeNum).append(" trees.\n");
            }
        }

        System.out.println(sb);

    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA > rootB) {
            int tmp = rootA;
            rootA = rootB;
            rootB = tmp;
        }

        if(rootA == rootB) {
            parents[rootA] = 0;
        } else {
            parents[rootB] = rootA;
        }
    }
}