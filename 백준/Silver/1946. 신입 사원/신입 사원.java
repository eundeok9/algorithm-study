import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[][] candidates = new int[N][2];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                candidates[i][0] = Integer.parseInt(st.nextToken());
                candidates[i][1] = Integer.parseInt(st.nextToken());
            }

            // 서류 순위 기준 정렬
            Arrays.sort(candidates, Comparator.comparingInt(o -> o[0]));

            int count = 1;
            int minRank = candidates[0][1]; // 면접 순위의 최솟값

            for(int i=1; i<N; i++) {
                if(candidates[i][1] < minRank) {
                    count++;
                    minRank = candidates[i][1];
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}