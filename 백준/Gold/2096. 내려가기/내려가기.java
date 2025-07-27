import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[N][3];
        int[][] min = new int[N][3];

        for(int j=0; j<3; j++) {
            max[0][j] = map[0][j];
            min[0][j] = map[0][j];
        }

        for(int i=1; i<N; i++) {
            max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + map[i][0];
            max[i][1] = Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2])) + map[i][1];
            max[i][2] = Math.max(max[i-1][2], max[i-1][1]) + map[i][2];

            min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + map[i][0];
            min[i][1] = Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2])) + map[i][1];
            min[i][2] = Math.min(min[i-1][2], min[i-1][1]) + map[i][2];
        }

        int minAnswer = Integer.MAX_VALUE;
        int maxAnswer = -1;
        for(int j=0; j<3; j++) {
            maxAnswer = Math.max(max[N-1][j], maxAnswer);
            minAnswer = Math.min(min[N-1][j], minAnswer);
        }
        System.out.println(maxAnswer + " " + minAnswer);
    }
}