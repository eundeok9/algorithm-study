import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(M < K) {
            System.out.println(0);
            return;
        }

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            int count = 0;
            for(int j=0; j<K; j++) {
                if(map[i][j] == 0) count++;
            }
            if(count >= K) answer++;

            int lt = 0;
            for(int l=K; l<M; l++) {
                if(map[i][l] == 0) count++;
                if(map[i][lt] == 0) count--;

                lt++;

                if(count >= K) answer++;
            }
        }

        System.out.println(answer);
    }
}