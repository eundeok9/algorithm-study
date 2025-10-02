import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        boolean[] width = new boolean[N+1];
        boolean[] height = new boolean[M+1];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(type == 1) {
                width[num] = true;
            } else {
                height[num] = true;
            }
        }

        List<Integer> widthList = new ArrayList<>();

        int prev = 0;
        int cur = 0;
        while(cur < N) {
            if(width[cur]) {
                widthList.add(cur - prev);
                prev = cur;
            }
            cur++;
        }
        widthList.add(cur - prev);

        List<Integer> heightList = new ArrayList<>();
        prev = 0;
        cur = 0;
        while(cur < M) {
            if(height[cur]) {
                heightList.add(cur - prev);
                prev = cur;
            }
            cur++;
        }
        heightList.add(cur - prev);

        int max = 0;
        for(int w: widthList) {
            for(int h: heightList) {
                max = Math.max(w * h, max);
            }
        }

        System.out.println(max);
    }
}