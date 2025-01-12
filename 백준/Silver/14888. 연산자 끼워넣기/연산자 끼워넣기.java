import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] num;
    static int[] operationCnt = new int[4];
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    static List<Integer> operation = new ArrayList<>();

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

        backTracking(0);
        System.out.println(maxValue + "\n" + minValue);
    }

    public static void backTracking(int depth) {
        if(depth == N-1) {
            // 계산
            int res = num[0];
            for(int i=1; i<N; i++) {
                int op = operation.get(i-1);

                switch (op) {
                    case 0: // 덧셈;
                        res += num[i];
                        break;
                    case 1: // 뺄셈
                        res -= num[i];
                        break;
                    case 2: // 곱셈
                        res *= num[i];
                        break;
                    case 3: // 나눗셈
                        if (num[i] == 0) continue;
                        if (res < 0 || num[i] < 0) { // 둘 중에 하나가 음수면
                            int tmp = Math.abs(res) / Math.abs(num[i]);
                            res = -1 * tmp;
                        } else {
                            res /= num[i];
                        }
                        break;
                }
            }

            minValue = Math.min(res, minValue);
            maxValue = Math.max(res, maxValue);

            return;
        }

        for(int i=0; i<4; i++) {
            if(operationCnt[i] != 0) {
                operationCnt[i]--;
                operation.add(i);
                backTracking(depth + 1);
                operationCnt[i]++;
                operation.remove(operation.size() - 1);
            }
        }
    }
}
