import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[]> line = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line.add(new int[] {a, b});
        }

        Collections.sort(line, (a,b) -> Integer.compare(a[0], b[0]));

        int[] lis = new int[N];
        lis[0] = line.get(0)[1];
        int len = 1;
        for(int i=1; i<N; i++) {
            if(line.get(i)[1] > lis[len-1]) {
                lis[len++] = line.get(i)[1];
            } else {
                int idx = search(0, len-1, line.get(i)[1], lis);
                lis[idx] = line.get(i)[1];
            }
        }
        System.out.println(N - len);
    }

    public static int search(int left, int right, int target, int[] lis) {
        int mid;

        while(left < right) {
            mid = (left + right) / 2;

            if(lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}