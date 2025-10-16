import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isCheck = new boolean[26];

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < n; t++) {
            String option = br.readLine();
            String str = findRepresentativeKey(option, isCheck);

            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    static String findRepresentativeKey(String option, boolean[] isCheck) {
        for (int i = 0; i < option.length(); i++) {
            char alphabet = option.charAt(i);

            if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char)('a' + (alphabet - 'A'));
            }
            int num = alphabet - 'a';

            if (!isCheck[num]) {
                isCheck[num] = true;
                String key = makeKey(option, i);
                return key;
            }

            while (true) {
                i++;
                if (i >= option.length() || option.charAt(i) == ' ') break;
            }
        }
        
        for (int i = 1; i < option.length(); i++) {
            if (option.charAt(i) == ' ') {
                i += 1;
                continue;
            }

            char alphabet = option.charAt(i);

            if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char)('a' + (alphabet - 'A'));
            }
            int num = alphabet - 'a';

            if (!isCheck[num]) {
                isCheck[num] = true;
                String key = makeKey(option, i);
                return key;
            }
        }
        
        return option;
    }

    // option의 idx번째 글자가 단축키로 지정된 경우
    static String makeKey(String option, int idx) {
        StringBuilder sb = new StringBuilder();
        sb.append(option, 0, idx);
        sb.append("[").append(option.charAt(idx)).append("]");
        sb.append(option.substring(idx+1));

        return sb.toString();
    }
}