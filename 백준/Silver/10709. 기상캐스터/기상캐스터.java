import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] answer = new int[H][W];

        for(int i=0; i<H; i++) {
            String s = br.readLine();
            int time = -1;
            
            for(int j=0; j<W; j++) {
                if(s.charAt(j) == 'c') {
                    time = 0;
                    answer[i][j] = time;
                } else {
                    if(time == -1) {
                        answer[i][j] = -1;
                    } else {
                        time++;
                        answer[i][j] = time;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}