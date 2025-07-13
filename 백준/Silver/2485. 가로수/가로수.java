import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        int[] gaps = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            gaps[i] = trees[i + 1] - trees[i];
        }

        int commonGap = gaps[0];
        for (int i = 1; i < gaps.length; i++) {
            commonGap = gcd(commonGap, gaps[i]);
        }

        int count = 0;
        for (int gap : gaps) {
            count += (gap / commonGap) - 1;
        }

        System.out.println(count);
    }
}
