import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensors = new int[N];
        int[] diff = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        for(int i=1; i<N; i++) {
            diff[i-1] = sensors[i] - sensors[i-1];
        }

        Arrays.sort(diff);

        int answer = 0;
        for(int i=0; i<N-K; i++) {
            answer += diff[i];
        }

        System.out.println(answer);
    }
}