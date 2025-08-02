import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            map.put(st.nextToken(), 0);
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // 인기도 내림차순
            }
            return a.getKey().compareTo(b.getKey()); // 이름 오름차순
        });

        for (Map.Entry<String, Integer> e : list) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}