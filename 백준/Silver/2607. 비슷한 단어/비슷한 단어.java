import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 기준 단어
        String s1 = br.readLine();
        int[] alphabet = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int idx = s1.charAt(i) - 'A';
            alphabet[idx]++;
        }

        int[] check;
        for (int i = 0; i < n - 1; i++) {
            check = alphabet.clone();
            String s2 = br.readLine();

            // 단어 길이가 1 이상 차이 날 경우
            if (Math.abs(s2.length() - s1.length()) > 1) continue;

            // 같은 알파벳 개수 체크
            int cnt = 0;
            for (int j = 0; j < s2.length(); j++) {
                int idx = s2.charAt(j) - 'A';

                if (check[idx] > 0) {
                    cnt++;
                    check[idx]--;
                }
            }

            if (s1.length() - 1 == s2.length()) { // 기준 단어보다 길이가 1 작을 경우
                if (cnt == s2.length()) answer++;
            } else if (s1.length() + 1 == s2.length()) {// 기준 단어보다 길이가 1 클 경우
                if (cnt == s1.length()) answer++;
            } else if (s1.length() == s2.length()) { // 두 단어의 길이가 같을 경우
                // 문자 구성이 같을 때
                if (cnt == s1.length()) answer++;
                // 한글자만 다를 때
                else if (cnt == s2.length() - 1) answer++;
            }

        }
        System.out.println(answer);
    }
}
