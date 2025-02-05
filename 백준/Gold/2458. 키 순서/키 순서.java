import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] distance = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            distance[a][b] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(distance[i][k] == 1 && distance[k][j] == 1) {
                        distance[i][j] = 1;
                    }
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=N; i++) {
            int possible = 0; // 키 비교가 가능한 학생 수
            // distance[j][i] : i보다 작은 학생 수
            // distance[i][j] : i보다 큰 학생 수
            for(int j=1; j<=N; j++) {
                possible += distance[i][j] + distance[j][i];
            }

            // 키 비교가 가능한 학생 수가 전체 학생의 수에서 자신을 제외한 수와 같다면
            // 키 순서를 알 수 있는 학생임
            if(possible == N-1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}