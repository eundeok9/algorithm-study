import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int total = 0;
        int maxCost = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
            maxCost = Math.max(maxCost, arr[i]);
        }

        long left = maxCost; // 하루 최대 소비액
        long right = total; // 전체 소비액의 합
        long answer = right;

        while(left <= right) {
            long mid = (left + right) / 2;
            if(isPossible(arr, mid, M)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean isPossible(int[] cost, long k, int M) {
        int count = 1; // 첫 날에 인출하는 것으로 시작
        long current = k;
        for(int i=0; i<cost.length; i++) {
            if(current < cost[i]) {
                count++;
                current = k;
            }
            current -= cost[i];
            if(count > M) return false;
        }
        return true;
    }
}