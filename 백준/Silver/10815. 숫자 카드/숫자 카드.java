import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] answer = new int[M];
        for(int i=0; i<M; i++) {
            if(set.contains(Integer.parseInt(st.nextToken()))) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        for(int i=0; i<M; i++) {
            System.out.print(answer[i] + " ");
        }
    }

}
