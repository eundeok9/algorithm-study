import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();
            if(set.contains(name)) {
                set.remove(name);
            } else {
                set.add(name);
            }
        }
        
        List<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String name: list) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
