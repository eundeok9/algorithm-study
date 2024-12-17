import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Boolean> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();
            if(cmd.equals("enter")) {
                map.put(name, true);
            } else {
                map.put(name, false);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String name: list) {
            if(map.get(name)) {
                sb.append(name).append("\n");
            }
        }
        System.out.println(sb);
    }
}
