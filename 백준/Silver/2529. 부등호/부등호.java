import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static String[] sarr;
    static boolean[] visited = new boolean[10];
    static HashSet<String> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        sarr = new String[K];
        for(int i=0; i<K; i++) {
            sarr[i] = st.nextToken();
        }

        backTracking(0, "");

        List<String> list = new ArrayList<>(answer);
        Collections.sort(list);

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    public static void backTracking(int depth, String str) {
        if(depth == K+1) {
            boolean flag = true;
            for(int i=0; i<K; i++) {
                String s = sarr[i];
                if(s.equals("<")) {
                    if(str.charAt(i) >= str.charAt(i+1)) {
                        flag = false;
                        break;
                    }
                } else {
                    if(str.charAt(i) <= str.charAt(i+1)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                answer.add(str);
            }
            return;
        }
        for(int i=0; i<=9 ;i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTracking(depth + 1, str + i);
                visited[i] = false;
            }
        }
    }
}
