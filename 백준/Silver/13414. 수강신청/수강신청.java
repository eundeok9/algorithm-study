import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int k =  Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i=0; i<l; i++) {
            String id = br.readLine();
            set.remove(id);
            set.add(id);
        }

        int count = 0;
        for(String id: set) {
            if(count == k) break;
            sb.append(id).append("\n");
            count++;
        }
        System.out.println(sb);
    }
}