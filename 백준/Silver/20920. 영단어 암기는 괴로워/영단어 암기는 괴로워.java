import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(s.length() >= M) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> {
           if(map.get(o1) == map.get(o2)) {
               if (o1.length() == o2.length()) {
                   return o1.compareTo(o2);
               }
               return o2.length() - o1.length();
           }
           return map.get(o2) - map.get(o1);
        });

        for(String s: list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}