import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 도우 가격
        int B = Integer.parseInt(st.nextToken()); // 토핑 가격
        int C = Integer.parseInt(br.readLine()); // 도우 열량

        Integer[] kcals = new Integer[N];
        for(int i=0; i<N; i++) {
            kcals[i] = Integer.parseInt(br.readLine()); // 토핑 열량
        }
        Arrays.sort(kcals, Collections.reverseOrder());

        int price = A;
        int kcal = C;
        int best = kcal / price;

        for(int i=0; i<N; i++) {
            int k = i+1;
            price = A + B * k;
            kcal += kcals[i];
            int cur = kcal / price;

            if(best <= cur) {
                best = cur;
            } else {
                break;
            }
        }
        System.out.println(best);
    }
}