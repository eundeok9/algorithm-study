import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            set.add(getMinCycleWord(s));
        }

        System.out.println(set.size());
    }

    // 사이클 단어 중 사전순으로 가장 빠른거 구하기
    public static String getMinCycleWord(String s) {
        String min = s;
        String doubled = s + s;
        int len = s.length();

        for(int i=1; i<len; i++) {
            String cycled = doubled.substring(i, i+len);
            if(cycled.compareTo(min) < 0) {
                min = cycled;
            }
        }

        return min;
    }
}