import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        Map<String, Integer> map = new TreeMap<>(); // 사전순 정렬을 위해 TreeMap 사용
        int cnt = 0;

        while ((s = br.readLine()) != null) {
            cnt++;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String key : map.keySet()) {
            double percentage = (double) map.get(key) * 100 / cnt;
            sb.append(key).append(" ").append(String.format("%.4f", percentage)).append("\n");
        }

        System.out.print(sb);
    }
}