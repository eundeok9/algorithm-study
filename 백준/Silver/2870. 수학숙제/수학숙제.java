import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String norm(String s) {
        int i=0;
        while(i < s.length() && s.charAt(i) == '0') i++;
        return (i == s.length() ? "0" : s.substring(i));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> nums = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            StringBuilder cur = new StringBuilder();
            for(char c: s.toCharArray()) {
                if(Character.isDigit(c)) cur.append(c);
                else if(cur.length() > 0) {
                   nums.add(norm(cur.toString()));
                   cur.setLength(0);
                }
            }
            if(cur.length() > 0) {
                nums.add(norm(cur.toString()));
            }
        }

        nums.sort((a, b) -> a.length() != b.length() ? a.length() - b.length() : a.compareTo(b));

        StringBuilder sb = new StringBuilder();
        for(String s: nums) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
