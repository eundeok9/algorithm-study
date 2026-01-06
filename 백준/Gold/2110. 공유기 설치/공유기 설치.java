import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1; // 설치할 수 있는 최소 거리
        int right = arr[N-1] - arr[0]; // 설치할 수 있는 최대 거리

        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            // mid 거리로 C개 설치 가능한지
            int count = 1;
            int last = arr[0]; // 마지막 설치 위치

            for(int i=1; i<N; i++) {
                if(arr[i] - last >= mid) {
                    count++;
                    last = arr[i];
                }
            }

            if(count >= C) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}