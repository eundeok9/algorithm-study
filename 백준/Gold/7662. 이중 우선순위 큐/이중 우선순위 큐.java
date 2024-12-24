import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            // 명령 수행
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if(map.isEmpty()) continue;
                    int x;
                    if(num == 1) { // 최댓값 삭제
                        x = map.lastKey();
                    } else { // 최솟값 삭제
                        x = map.firstKey();
                    }
                    if(map.get(x) == 1) {
                        map.remove(x);
                    } else if(map.get(x) > 1) {
                        map.put(x, map.get(x) - 1);
                    }
                }
            }

            // 결과 저장
            if(map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
