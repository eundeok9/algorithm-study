import java.io.*;
import java.util.*;
public class Main {
    static HashSet<String> set;
    static int N, K;
    static int[] numbers;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        numbers = new int[N];
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        set = new HashSet<>();
        selected = new boolean[N];
        backTracking( 0, "");

        System.out.println(set.size());
    }

    static void backTracking(int depth, String s) {
        if(depth == K) {
//            System.out.println(s);
            set.add(s);
            return;
        }

        for(int i=0; i<N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                backTracking(depth + 1, s + numbers[i]);
                selected[i] = false;
            }
        }
    }
}
