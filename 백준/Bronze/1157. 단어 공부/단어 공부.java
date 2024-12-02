import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = Character.toUpperCase(s.charAt(i));
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int maxCnt = 0;
        char answer = '?';
        for(Character ch: map.keySet()) {
            int cnt = map.get(ch);
            if(maxCnt < cnt) {
                maxCnt = cnt;
                answer = ch;
            } else if (maxCnt == cnt) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
