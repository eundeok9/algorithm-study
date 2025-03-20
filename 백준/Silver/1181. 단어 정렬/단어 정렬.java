import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, (o1, o2) -> {
           if(o1.length() == o2.length()) {
               return o1.compareTo(o2);
           }
            return Integer.compare(o1.length(), o2.length());
        });

        for(String s: list) {
            System.out.println(s);
        }
    }
}