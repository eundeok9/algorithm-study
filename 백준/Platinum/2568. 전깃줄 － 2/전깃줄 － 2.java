import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

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
        int[] idx = new int[N];
        int[] trace = new int[N];
        Arrays.fill(trace, -1);

        lis[0] = line.get(0)[1];
        idx[0] = 0;
        int len = 1;

        for(int i=1; i<N; i++) {
            if(line.get(i)[1] > lis[len-1]) {
                trace[i] = idx[len - 1];
                lis[len] = line.get(i)[1];
                idx[len++] = i;
            } else {
                int index = search(0, len-1, line.get(i)[1], lis);
                lis[index] = line.get(i)[1];
                idx[index] = i;
                if(index > 0) trace[i] = idx[index - 1];
            }
        }

        boolean[] isInLIS = new boolean[N];
        for(int i = idx[len-1]; i != -1; i = trace[i]) {
            isInLIS[i] = true;
        }

        sb.append(N-len).append("\n");
        for(int i=0; i<N; i++) {
            if(!isInLIS[i]) sb.append(line.get(i)[0]).append("\n");
        }
        System.out.println(sb);
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