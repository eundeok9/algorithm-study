import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int same = M * (M - 1) / 2; // 같은 지역 리그 경기 수
            int other = M * (N - 1) * N * M / 2; // 다른 지역 리그 경기 수

            int b = 1;
            int prev = -1;

            while(true) {
                int a = b * K;
                int x = same * a * N; // 같은 지역 리그 내 총 경기 수
                int y = other * b; // 다른 지역 리그 간 총 경기 수

                if(x+y <= D) {
                    prev = x + y;
                } else {
                    break;
                }
                b++;
            }
            System.out.println(prev);
        }
    }
}
