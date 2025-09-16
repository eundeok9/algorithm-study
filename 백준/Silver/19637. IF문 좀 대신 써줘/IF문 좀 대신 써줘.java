import java.io.*;
import java.util.*;
public class Main {
    static class Title {
        String name;
        int power;

        Title(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Title[] titles = new Title[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            titles[i] = new Title(name, power);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int x = Integer.parseInt(br.readLine());
            int idx = lowerBound(titles, x);
            sb.append(titles[idx].name).append("\n");
        }
        System.out.println(sb);
    }

    // 처음으로 power >= x 가 되는 인덱스
    static int lowerBound(Title[] titles, int x) {
        int left = 0, right = titles.length - 1;
        int result = titles.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(titles[mid].power >= x) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}