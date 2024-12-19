import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static long[] factorial;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        factorial = new long[N+1];
        factorial[0] = 1;
        for(int i=1; i<=N; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        // 1번 문제
        if(num == 1) {
            long k = Long.parseLong(st.nextToken());
            for(int i=0; i<N; i++) {
                for(int j=1; j<=N; j++) {
                    if(visited[j]) continue;

                    if(k <= factorial[N-1-i]) {
                        sb.append(j).append(" ");
                        visited[j] = true;
                        break;
                    } else {
                        k -= factorial[N-i-1];
                    }
                }
            }
        }
        // 2번 문제
        else {
            int[] goal = new int[N];
            for(int i=0; i<N; i++) {
                goal[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 1;
            for(int i=0; i<N; i++) {
                for(int j=1; j<goal[i]; j++) {
                    if(visited[j]) continue;

                    answer += factorial[N-i-1];
                }
                visited[goal[i]] = true;
            }
            sb.append(answer);
        }
        System.out.println(sb);
    }
}
