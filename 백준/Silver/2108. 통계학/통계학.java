import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int median = 10000;
        int mode = 10000;
        
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[num + 4000]++;
            
            if(max < num) {
                max = num;
            }
            if(min > num) {
                min = num;
            }
        }
        
        int count = 0; // 중앙값 빈도 누적 수
        int mode_max = 0; // 최빈값의 최댓값
        
        // 동일한 최빈값 등장 여부
        boolean flag = false;
        
        for(int i = min + 4000; i<=max+4000; i++) {
            if(arr[i] > 0) {
                // 중앙값 찾기
                if(count<(N+1)/2) {
                    count += arr[i]; // i값의 빈도수를 count에 누적
                    median = i - 4000;
                }
                
                // 최빈값 찾기
                if(mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;
                }
                else if(mode_max == arr[i] && flag) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }
        
        System.out.println((int)Math.round((double)sum / N));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);
    }
}