import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N][N];
        int[] rank = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            info[i][0] = x;
            info[i][1] = y;
        }

        Arrays.fill(rank, 1);

        for(int i=0; i<N; i++) {
            int curX = info[i][0];
            int curY = info[i][1];
            for(int j=0; j<N; j++) {
                if(i==j) continue;

                if(curX < info[j][0] && curY < info[j][1]) {
                    rank[i]++;
                }
            }
        }

        for(int i: rank) {
            System.out.print(i + " ");
        }
    }
}

// 몸무게 키
// x  y
// x > p && y > q => a > b
// 자신보다 더 큰 덩치의 사람 = k, 그 사람의 덩치등수 k+1
// 각 사람의 덩치 등수
// 2 <= N <= 50