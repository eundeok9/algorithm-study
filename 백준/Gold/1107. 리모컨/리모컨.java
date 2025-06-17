import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static boolean[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        broken = new boolean[11];
        if(M>0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        
        int ans = Math.abs(N - 100); // 숫자 버튼 안쓸 때 (최대 이동수)
        for(int i=0; i<10000001; i++) {
            int cnt = check(i);
            if(cnt != 0) {
                ans = Math.min(ans, Math.abs(N - i) + cnt);
            }
        }
        System.out.println(ans);
    }
    
    public static int check(int n) {
        if (n==0) {
            if(broken[n]) return 0;
            else return 1;
        }
        
        int cnt = 0;
        while(n > 0) {
            if(broken[n%10]) return 0;
            cnt++;
            n /= 10;
        }
        
        return cnt;
    }
}
