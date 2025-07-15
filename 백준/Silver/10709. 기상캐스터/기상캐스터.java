import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] cloud = new char[H][W];
        int[][] answer = new int[H][W];

        for(int i=0; i<H; i++) {
            String s = br.readLine();
            cloud[i] = s.toCharArray();
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                char c = cloud[i][j];
                if(c=='c') {
                    answer[i][j] = 0;
                } else {
                    boolean flag = false;
                    int cnt = 1;
                    int col = j-1;
                    while(col >= 0) {
                        if(cloud[i][col] == 'c') {
                            flag = true;
                            break;
                        } else {
                            cnt++;
                            col--;
                        }
                    }

                    if(!flag) {
                        answer[i][j] = -1;
                    } else {
                        answer[i][j] = cnt;
                    }
                }
            }
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}