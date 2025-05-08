import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        String result = "NO";

        int x = 0, y = 0;
        int cnt = 0;
        for(int i=0; i<K; i++) {
            for(int j=0; j<N; j++) {
                if(s.charAt(j) == 'U') {
                    x++;
                }
                if(s.charAt(j) == 'R') {
                    y++;
                }
                if(s.charAt(j) == 'D') {
                    x--;
                }
                if(s.charAt(j) == 'L') {
                    y--;
                }

                if(x==0 && y==0) {
                    System.out.println("YES");
                    return;
                }
                cnt++;
            }
            if(cnt > 5000000) {
                break;
            }
        }
        System.out.println(result);
    }
}