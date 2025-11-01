import java.io.*;
public class Main {
    static final int N = 9;
    static int[] nums;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = new int[N];
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        selected = new int[7];
        backTracking(0, 0);
    }

    static void backTracking(int depth, int start) {
        if(depth == 7) {
            int sum = 0;
            for(int h: selected) sum += h;
            if(sum == 100) {
                for(int h: selected) System.out.println(h);
                System.exit(0);
            }
            return;
        }

        for(int i=start; i<N; i++) {
            selected[depth] = nums[i];
            backTracking(depth+1, i+1);
        }
    }
}