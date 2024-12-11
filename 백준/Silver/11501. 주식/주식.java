import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            long answer = 0;

            // 주가를 담는 배열
            int[] nums = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int max = nums[N-1];
            for(int j=N-2; j>=0; j--) {
                if(nums[j] <= max) { // 현재 시세가 최대값보다 적다면 판매
                    answer += max - nums[j];
                }
                else { // 현재 시세가 최대값보다 크다면 최대값 갱신
                    max = nums[j];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
