import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] num;
    static int[] operationCnt = new int[4];
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operationCnt[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, num[0]);
        System.out.println(maxValue + "\n" + minValue);
    }

    public static void backTracking(int depth, int currentValue) {
        if(depth == N-1) {
            minValue = Math.min(currentValue, minValue);
            maxValue = Math.max(currentValue, maxValue);

            return;
        }

        for(int i=0; i<4; i++) {
            if(operationCnt[i] > 0) {
                operationCnt[i]--;
                int newValue = currentValue;

                switch(i) {
                    case 0: newValue += num[depth + 1]; break;
                    case 1: newValue -= num[depth + 1]; break;
                    case 2: newValue *= num[depth + 1]; break;
                    case 3:
                        if(newValue < 0) {
                            newValue = -1 * (Math.abs(newValue) / num[depth + 1]);
                        } else {
                            newValue /= num[depth + 1];
                        }
                        break;
                }
                backTracking(depth + 1, newValue);
                operationCnt[i]++;

            }
        }
    }
}
