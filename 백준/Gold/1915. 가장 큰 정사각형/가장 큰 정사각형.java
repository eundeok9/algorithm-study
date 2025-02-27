import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+1];
        int[][] prefixSum = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            String s = br.readLine();
            for(int j=1; j<=m; j++) {
                map[i][j] = s.charAt(j-1) - '0';
                prefixSum[i][j] = map[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        int maxSize = 0;

        for(int size = Math.min(n, m); size > 0; size--) {
            boolean found = false;

            for(int i=size; i<=n; i++) {
                for(int j=size; j<=m; j++) {
                    // (i, j)를 우하단 꼭짓점으로 하는 size*size 부분합 계산
                    int total = prefixSum[i][j] - prefixSum[i-size][j] - prefixSum[i][j-size] + prefixSum[i-size][j-size];

                    if(total == size * size) { // 모든 값이 1일 경우
                        maxSize = size;
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }
            if(found) break;
        }

        System.out.println(maxSize * maxSize);
    }
}