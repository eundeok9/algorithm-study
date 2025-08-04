import java.io.*;
import java.util.*;
public class Main {
    static int[][] preferMap;
    static int[] selected;
    static int N, M;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        preferMap = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                preferMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new int[3];
        backTracking(0, 0);

        System.out.println(answer);
    }

    static void backTracking(int depth, int start) {
        if(depth == 3) {
            int sum = 0;
            for(int i=0; i<N; i++) {
                int tmpMax = 0;
                for(int j=0; j<3; j++) {
                    tmpMax = Math.max(preferMap[i][selected[j]], tmpMax);
                }
                sum += tmpMax;
            }

            answer = Math.max(answer , sum);
            return;
        }

        for(int i=start; i<M; i++) {
            selected[depth] = i;
            backTracking(depth + 1, start + 1);
        }
    }
}