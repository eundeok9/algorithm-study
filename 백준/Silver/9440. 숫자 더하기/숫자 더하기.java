import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n==0) break;

            ArrayList<Integer> arr = new ArrayList<>();
            int zeroCnt = 0;
            for(int i=0; i<n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur==0) {
                    zeroCnt++;
                    continue;
                }
                arr.add(cur);
            }

            Collections.sort(arr);

            long answer = n%2 == 0 ? 0 : arr.get(0)*10;
            int idx = n%2 == 0 ? 0 : 1;

            if(zeroCnt > 0) {
                if(n%2==0) {
                    answer += arr.get(idx) + arr.get(idx+1);
                    idx += 2;
                } else {
                    answer += arr.get(idx);
                    idx += 1;
                    zeroCnt -=1;
                }
                answer *= 10;
            }

            while(zeroCnt >= 2) {
                answer *= 10;
                zeroCnt -= 2;
            }
            if(zeroCnt == 1) {
                answer += arr.get(idx);
                answer *= 10;
                idx++;
            }

            for(; idx < arr.size(); idx+=2) {
                answer += arr.get(idx) + arr.get(idx+1);
                answer *= 10;
            }

            sb.append(answer/10).append("\n");
        }
        System.out.println(sb);
    }
}