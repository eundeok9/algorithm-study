import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i=0; i<N; i++) {
            String name = br.readLine();
            map.put(i+1, name);
            map2.put(name, i+1);
        }

        for(int i=0; i<M; i++) {
            String input = br.readLine();

            if(Character.isDigit(input.charAt(0))) {
                sb.append(map.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(map2.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
