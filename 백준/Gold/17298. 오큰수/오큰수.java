import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            while(!stack.empty() && nums[stack.peek()] < nums[i]) {
                nums[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            nums[stack.pop()] = -1;
        }

        for(int i=0; i<N; i++) {
            sb.append(nums[i]).append(" ");
        }
        System.out.println(sb);
    }
}
