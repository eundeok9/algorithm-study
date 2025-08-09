import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> cnt = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            cnt.put(name, cnt.getOrDefault(name, 0) + 1);
        }
        for (int i = 0; i < N - 1; i++) {
            String name = br.readLine();
            cnt.put(name, cnt.get(name) - 1);
            if (cnt.get(name) == 0) cnt.remove(name);
        }

        for (String name : cnt.keySet()) {
            System.out.println(name);
        }
    }
}