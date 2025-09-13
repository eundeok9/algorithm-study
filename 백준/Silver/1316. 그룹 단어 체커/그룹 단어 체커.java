import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i<N; i++) {
            HashSet<Character> set = new HashSet<>();
            String s = br.readLine();
            boolean flag = true;
            for(int j=0; j<s.length(); j++) {
                if(j==0) {
                    set.add(s.charAt(j));
                    continue;
                }
                if(set.contains(s.charAt(j)) && (s.charAt(j-1) != s.charAt(j))) {
                    flag = false;
                    break;
                }
                set.add(s.charAt(j));
            }

            if(flag) answer++;
        }

        System.out.println(answer);
    }
}