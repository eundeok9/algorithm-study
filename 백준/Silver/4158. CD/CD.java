import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;

            HashSet<Integer> set = new HashSet<>();
            int cnt = 0;

            for(int i=0; i<N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            for(int i=0; i<M; i++) {
                int n = Integer.parseInt(br.readLine());
                if(set.contains(n)) {
                    cnt++;
                    set.remove(n);
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}