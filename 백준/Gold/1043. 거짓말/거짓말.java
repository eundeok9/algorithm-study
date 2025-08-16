import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knownPeople = Integer.parseInt(st.nextToken());
        int[] known = new int[knownPeople];
        for(int i=0; i<knownPeople; i++) {
            known[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> parties = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            int[] party = new int[partySize];
            for(int j=0; j<partySize; j++) {
                party[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(party);

            // 같은 파티 사람들 묶기
            for(int j=1; j<partySize; j++) {
                union(party[0], party[j]);
            }
        }

        // 진실 아는 사람들의 루트 저장
        boolean[] knownRoot = new boolean[N+1];
        for(int n: known) {
            knownRoot[find(n)] = true;
        }

        int result = 0;
        for(int[] party: parties) {
            int root = find(party[0]);
            if(!knownRoot[root]) {
                result++;
            }
        }

        System.out.println(result);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!=b) parent[b] = a;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}