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

        long count = 0;
        for(int i=0; i<N-2; i++) {
            if(arr[i] > 0) break; // 초기값이 양수이면 그 다음부터는 다 양수이므로 합이 0이 될 수 없음

            int left = i + 1, right = N-1;
            while(left < right) {
                long sum = (long) arr[left] + arr[right] + arr[i];

                if(sum == 0) {
                    if(arr[left] == arr[right]) {
                        // left ~ right까지 모두 같은 수라는 뜻
                        int n = right - left + 1;
                        count += (long) n * (n-1) / 2;
                        break;
                    } else {
                        // left와 같은 수 / right와 같은 수의 개수 구하기
                        int cntLeft = 1, cntRight = 1;
                        while(left + 1 < right && arr[left] == arr[left+1]) {
                            cntLeft++;
                            left++;
                        }
                        while(right - 1 > left && arr[right] == arr[right-1]) {
                            cntRight++;
                            right--;
                        }
                        count += (long) cntLeft * cntRight;
                        left++;
                        right--;
                    }

                }
                else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(count);
    }
}