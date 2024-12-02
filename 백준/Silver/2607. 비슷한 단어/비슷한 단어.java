import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 기준 단어
        String s1 = br.readLine();

        // 기준 단어에 각 문자가 몇 번 있는지
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i=0; i<s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        // 비슷한 문자 몇 개인지 count
        int answer = 0;
        for(int i=0; i<n-1; i++) {
            String s2 = br.readLine();

            // 길이가 2이상 차이날 경우
            if(Math.abs(s1.length() - s2.length()) > 1) {
                continue;
            }

            HashMap<Character, Integer> map2 = new HashMap<>(map1);
            int cnt = 0;
            for(int j=0; j<s2.length(); j++) {
                char c = s2.charAt(j);
                if(map2.containsKey(c)) {
                    if (map2.get(c) > 0) {
                        map2.put(c, map2.get(c) - 1);
                        cnt++;
                    }
                }
            }

            if(s1.length() -1 == s2.length()) {
                if(cnt == s2.length()) answer++;
            } else if(s1.length() + 1 == s2.length()) {
                if(cnt == s1.length()) answer++;
            } else if(s1.length() == s2.length()) {
                if(cnt == s1.length()) answer++;
                else if(cnt == s2.length() - 1) answer++;
            }
        }

        System.out.println(answer);
    }
}
