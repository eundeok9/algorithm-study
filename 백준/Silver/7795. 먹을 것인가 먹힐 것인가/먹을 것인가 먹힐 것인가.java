import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] a = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] b = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int answer = 0;
            for(int i=0; i<N; i++) {
                int target = a[i];
                int left = 0, right = M-1, count = 0;
                while(left <= right) {
                    int mid = (left + right) / 2;
                    if(b[mid] < target) {
                        left = mid + 1;
                        count = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                answer += count;
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}