import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        List<String> compare = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(br.readLine());
            compare.add(list.get(i));
        }

        Collections.sort(compare);
        if(list.equals(compare)) {
            System.out.println("INCREASING");
            return;
        }

        Collections.sort(compare, Collections.reverseOrder());
        if(list.equals(compare)) {
            System.out.println("DECREASING");
            return;
        }

        System.out.println("NEITHER");
    }
}