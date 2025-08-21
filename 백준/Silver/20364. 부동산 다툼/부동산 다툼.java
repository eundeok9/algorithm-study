import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            int x = Integer.parseInt(br.readLine());
            int cur = x, block = 0; // block: 마주치게 되는 곳

            while(cur > 0) {
                if(visited[cur]) {
                    block = cur;
                }
                cur >>= 1; // cur /= 2
            }

            if(block == 0) visited[x] = true;
            sb.append(block).append("\n");
        }
        System.out.println(sb);
    }
}