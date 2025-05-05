import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] order = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            int idx = 1;
            while(true) {
                if(arr[i] == 0 && order[idx] == 0) {
                    order[idx] = i;
                    break;
                }
                else if(order[idx] == 0) {
                    arr[i]--;
                }

                idx++;
            }
        }

        for(int i=1; i<=N; i++) {
            System.out.print(order[i] + " ");
        }
    }
}
