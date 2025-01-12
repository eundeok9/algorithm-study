import java.io.*;
import java.util.*;
public class Main {
    static int N, M, B;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(map[i][j], minHeight);
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int bestHeight = 0;

        // 가능한 모든 높이에 대해 계산
        for(int h=minHeight; h<=maxHeight; h++) {
            int time = 0;
            int blocks = B;

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    int diff = map[i][j] - h;

                    if(diff > 0) {
                        // 블록 제거
                        time += diff * 2; // 1개당 2초
                        blocks += diff;
                    } else if(diff < 0) {
                        time += -1 * diff; // 1개당 1초
                        blocks += diff; // diff가 음수이므로 블록 개수 감소
                    }
                }
            }

            // 블록 수가 부족하면 불가능
            if(blocks < 0) continue;

            if(time < minTime || (time == minTime && h > bestHeight)) {
                minTime = time;
                bestHeight = h;
            }
        }

        System.out.println(minTime + " " + bestHeight);
    }
}
