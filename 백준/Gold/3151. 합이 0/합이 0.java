import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long cnt = 0;
        for(int i=0; i<N-1; i++) {
            if(arr[i] > 0) break;

            int left = i+1, right = N-1;

            while(left<right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                if(sum == 0) {
                    if(arr[left] == arr[right]) {
                        int n = right - left + 1;
                        cnt += (long) n * (n-1) / 2;
                        break; // left부터 right까지 모두 탐색했으니 break
                    } else {
                        int leftCnt = 1; int rightCnt = 1;
                        while(left + 1 < right && arr[left] == arr[left+1]) {
                            leftCnt++;
                            left++;
                        }
                        while(right -1 > left && arr[right] == arr[right-1]) {
                            rightCnt++;
                            right--;
                        }

                        cnt += (long) leftCnt * rightCnt;
                        left++;
                        right--;
                    }
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}