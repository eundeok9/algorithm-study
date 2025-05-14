import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new TreeMap<>();
        for(int i=0; i<N; i++) {
            long card = Long.parseLong(br.readLine());
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        List<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for(Map.Entry<Long, Integer> entry: list) {
            System.out.println(entry.getKey());
            break;
        }
    }
}
