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
        int min = 1;
        int max = arr[arr.length - 1] - arr[0];
        int answer = 0;

        while(min <= max) {
            int mid = (min + max) / 2;

            int count = 1; // 설치 개수
            int num = arr[0]; // 첫번째 집 위치
            for(int i=1; i<N; i++) {
                if(count == C) break;
                if(arr[i] - num >= mid) {
                    count++;
                    num = arr[i];
                }
            }
            // 설치 가능
            if(count == C) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}