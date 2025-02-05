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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1; // i -> k -> j 경로가 있으면 구슬의 무게 판별 가능 (i < j)
                    }
                }
            }
        }

        int mid = (N+1) / 2; // 중간 순위를 가지려면 최대 mid - 1까지만 무겁거나 가벼워야 함
        int answer = 0;

        for(int i=1; i<=N; i++) {
            int heavy = 0, light = 0;
            for(int j=1; j<=N; j++) {
                if(dist[i][j] == 1) light++; // i보다 무거운 구술 개수
                if(dist[j][i] == 1) heavy++;
            }

            if(heavy >= mid || light >= mid) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}