import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][5];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int leader = 0;
        for(int i=0; i<N; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<5; j++) {
                for(int k=0; k<N; k++) {
                    if(map[i][j] == map[k][j] && i != k) {
                        set.add(k);
                    }
                }
            }
            if(set.size() > max) {
                max = set.size();
                leader = i;
            }
        }

        System.out.println(leader + 1);
    }
}
