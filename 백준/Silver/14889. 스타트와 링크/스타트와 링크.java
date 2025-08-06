import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] level;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        level = new int[N][N];
        selected = new boolean[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                level[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);
        System.out.println(minDiff);
    }

    static void backTracking(int depth, int start) {
        if(depth == N/2) {
            int sum1 = 0, sum2 = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(selected[i] && selected[j]) {
                        sum1 += level[i][j];
                    }
                    else if(!selected[i] && !selected[j]) {
                        sum2 += level[i][j];
                    }
                }
            }

            minDiff = Math.min(Math.abs(sum1-sum2), minDiff);
            return;
        }

        for(int i=start; i<N; i++) {
            selected[i] = true;
            backTracking(depth + 1, i + 1);
            selected[i] = false;
        }
    }
}