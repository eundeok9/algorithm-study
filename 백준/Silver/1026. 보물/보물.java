import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());

        int answer = 0;
        for(int i=0; i<N; i++) {
            answer += a.get(i) * b.get(i);
        }

        System.out.println(answer);
    }
}