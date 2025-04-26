import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine().split("\\.")[1];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(String s: map.keySet()) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}