import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map;
        while(T-->0) {
            int K = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            while(K-->0) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if(map.isEmpty()) continue;
                    int key;
                    if(num == -1) {
                        key = map.firstKey();
                    } else {
                        key = map.lastKey();
                    }

                    if(map.get(key) == 1) {
                        map.remove(key);
                    } else if(map.get(key) > 1) {
                        map.put(key, map.get(key) - 1);
                    }
                }
            }

            if(map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
