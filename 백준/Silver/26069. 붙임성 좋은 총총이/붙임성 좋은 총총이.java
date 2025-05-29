import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<String, Boolean> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            boolean a = map.getOrDefault(s1, false);
            boolean b= map.getOrDefault(s2, false);

            if(a || b) {
                map.put(s1, true);
                map.put(s2, true);
            } else if(s1.equals("ChongChong") || s2.equals("ChongChong")) {
                map.put(s1, true);
                map.put(s2, true);
            }
        }

        int sum = 0;
        for(String s: map.keySet()) {
            if(map.get(s)) sum++;
        }

        System.out.println(sum);
    }
}
