import java.io.*;
import java.util.*;
public class Main {
    static final int MAX = 30;
    static long[][] arr = new long[MAX+1][MAX+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp();
        
        StringBuilder sb = new StringBuilder();
        while(true) {
            int N = Integer.parseInt(br.readLine());
            
            if(N==0) break;

            sb.append(arr[N][N]);
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    static void dp() {
        arr[1][0] = 1;

        for(int w=0; w<=MAX; w++) {
            for(int h=0; h<=MAX; h++) {
                if(w < MAX) {
                    arr[w+1][h] += arr[w][h];
                }
                if(h < w) {
                    arr[w][h+1] += arr[w][h];
                }
            }
        }
    }
}