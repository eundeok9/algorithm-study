import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 현재 휴게소의 수
        int M = Integer.parseInt(st.nextToken()); // 더 지으려고 하는 휴게소의 수
        int L = Integer.parseInt(st.nextToken()); // 고속도로의 길이

        st = new StringTokenizer(br.readLine());
        int[] areas = new int[N+2];

        for(int i=1; i<=N; i++) {
            areas[i] = Integer.parseInt(st.nextToken());
        }
        areas[0] = 0; // 도로 시작점
        areas[N+1] = L; // 도로 끝 점

        Arrays.sort(areas);

        int left = 1;
        int right = L;
        int answer = L;

        while(left <= right) {
            int mid = (left + right) / 2; // 휴게소 간 거리
            int needed = 0; // 추가로 설치해야 하는 휴게소 수

            for(int i=1; i<areas.length; i++) {
                int gap = areas[i] - areas[i-1]; // 현재 휴게소 간 거리
                needed += (gap - 1) / mid; // 설치해야하는 휴게소 개수
            }

            if(needed <= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}