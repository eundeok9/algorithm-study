import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }

        int mid = (N+1)/2;
        int answer = 0;
        for(int i=1; i<=N; i++) {
            int light = 0;
            int heavy = 0;

            for(int j=1; j<=N; j++) {
                if(dist[i][j] == 1) light++;
                if(dist[j][i] == 1) heavy++;
            }

            if(light >= mid || heavy >= mid) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}