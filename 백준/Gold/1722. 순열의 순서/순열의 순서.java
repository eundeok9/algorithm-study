import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        long[] factorial;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        factorial = new long[N+1];
        // 팩토리얼 배열 (각 자리수에서 만들 수 있는 경우의 수)
        factorial[0] = 1;
        for(int i=1; i<=N; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        boolean[] used = new boolean[N+1];
        if(num == 1) {
            long k = Long.parseLong(st.nextToken());
            for(int i=0; i<N; i++) {
                for(int j=1; j<=N; j++) {
                    if(used[j]) continue;

                    if(k <= factorial[N-i-1]) {
                        sb.append(j).append(" ");
                        used[j] = true;
                        break;
                    } else {
                        k -= factorial[N-i-1];
                    }
                }
            }
        } else {
            int[] goal = new int[N];
            for(int i=0; i<N; i++) {
                goal[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 1;
            for(int i=0; i<N; i++) {
                for(int j=1; j<goal[i]; j++) {
                    if(used[j]) continue;
                    answer += factorial[N-1-i];
                }
                used[goal[i]] = true;
            }
            sb.append(answer);
        }

        System.out.println(sb);
    }
}
