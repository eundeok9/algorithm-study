import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] record = new String[N];
        for(int i=0; i<N; i++) {
            record[i] = br.readLine();
        }

        Arrays.sort(record, (o1, o2) -> {
            boolean o1HasBoj = o1.contains("boj.kr");
            boolean o2HasBoj = o2.contains("boj.kr");

            if(o1HasBoj && !o2HasBoj) return 1;
            if(!o1HasBoj && o2HasBoj) return -1;

            if(o1.length() != o2.length()) return o1.length() - o2.length();

            return o1.compareTo(o2);
        });

        for(String s: record) {
            System.out.println(s);
        }
    }
}