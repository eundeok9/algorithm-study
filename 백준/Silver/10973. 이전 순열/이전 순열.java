import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        if(nextPermutation()) {
            for(int i=0; i<N; i++) {
                System.out.print(num[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static boolean nextPermutation() {
        // 1. 뒤에서부터 탐색하며 현재 값보다 큰 값의 위치 찾기
        int i = num.length - 1;
        while(i > 0 && num[i] >= num[i-1]) {
            i--;
        }

        // 2. 만약 i가 0 이하라면, 이전 순열이 존재하지 않으므로 return false
        if(i<=0) return false;

        // 3. i의 오른쪽 값 중에 가장 작은 수 찾기
        int j = num.length - 1;
        while(num[j] >= num[i-1]) {
            j--;
        }

        // 4. i와 j 값 변경
        swap(i-1, j);
        
        // 5. i~j 범위의 값들 정렬
        j = num.length - 1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    public static void swap(int i, int j) {
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
    }
}
