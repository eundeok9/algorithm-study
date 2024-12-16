import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if(nextPermutation()) {
            for(int i=0; i<N; i++) {
                System.out.print(nums[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean nextPermutation() {
        // 뒤에서부터 탐색하면서 앞 < 뒤 를 만족하는 첫번째 지점(pivot) 찾기
        int i = nums.length - 1;
        while(i>0 && nums[i-1] >= nums[i]) {
            i--;
        }
        // 없다면 다음 순열 없음(가장 마지막 순열)
        if(i<=0) {
            return false;
        }

        // pivot 오른쪽 값 중 가장 작은 수 찾기
        int j = nums.length - 1;
        while(nums[j] <= nums[i-1]) {
            j--;
        }
        // 위치 변경
        swap(i-1, j);

        // pivot의 오른쪽 값을 오름차순 정렬 하기
        j = nums.length - 1;
        while(i<j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


}
