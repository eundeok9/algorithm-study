import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());

            // 테스트케이스 번호
            int n = Integer.parseInt(st.nextToken());

            // 학생들의 키를 담는 배열
            int size = st.countTokens();
            int[] numbers = new int[size];
            for(int i=0; i<size; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 몇 번 뒤로 물러서야하는지
            int cnt = 0;
            for(int i=1; i<size; i++) {
                for(int j=i-1; j>=0; j--) {
                    if(numbers[j] > numbers[i]) {
                        cnt++;
                    }
                }
            }

            System.out.println(n + " " + cnt);

        }

    }
}