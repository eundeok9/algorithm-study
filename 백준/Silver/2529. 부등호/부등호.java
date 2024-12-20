import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static String[] sarr;
    static boolean[] visited = new boolean[10];
    static String max = "", min = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        sarr = new String[K];
        for(int i=0; i<K; i++) {
            sarr[i] = st.nextToken();
        }

        backTracking(0, "");

        System.out.println(max);
        System.out.println(min);
    }

    public static void backTracking(int depth, String str) {
        if(depth == K+1) {
            if(min.isEmpty() || str.compareTo(min) < 0) {
                min = str;
            }
            if(max.isEmpty() || str.compareTo(max) > 0) {
                max = str;
            }
            return;
        }
        for(int i=0; i<=9 ;i++) {
            if(!visited[i]) {
                if(depth > 0) {
                    int prev = str.charAt(depth - 1) - '0';
                    if(sarr[depth-1].equals("<") && prev >= i) continue;
                    if(sarr[depth-1].equals(">") && prev <= i) continue;
                }
                visited[i] = true;
                backTracking(depth + 1, str + i);
                visited[i] = false;
            }
        }
    }
}
