import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[] {Integer.parseInt(st.nextToken()), 1});
            list.add(new int[] {Integer.parseInt(st.nextToken()), -1});
        }
        list.sort((a, b) -> (a[0] == b[0] ? (a[1] - b[1]) : (a[0]-b[0])));

        int curSum = 0; // 현재 시점에 존재하는 모기 수
        int maxSum = 0; // 최대 모기 수
        int start = 0; // 최대 겹치는 구간이 시작된 시간
        int end = 0; // 최대 겹치는 구간이 종료된 시간
        boolean flag = false; // 현재 최대 구간인지
        int prev = 0; // 이전에 처리한 시간

        for(int[] cur: list) {
            int time = cur[0];
            int val = cur[1];

            curSum += val;

            if(curSum == maxSum && prev == time) {
                flag = true;
            } else if(curSum > maxSum) {
                maxSum = curSum;
                start = time;
                flag = true;
            } else if(curSum < maxSum && flag) {
                end = time;
                flag = false;
            }
            prev = time;
        }
        System.out.println(maxSum);
        System.out.println(start + " " + end);
    }
}
