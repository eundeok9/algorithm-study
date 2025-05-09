import java.io.*;
public class Main {
    static String s;
    static int n;
    static char[] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        n = s.length();

        if(n==1) {
            System.out.println(0);
        }
        else {
            arr = new char[n];
            visited = new boolean[n];
            for(int i=0; i<n; i++) {
                arr[i] = s.charAt(i);
            }

            backTracking("", 0);

            System.out.println(answer == Integer.MAX_VALUE? 0 : answer);
        }
    }

    public static void backTracking(String cur, int depth) {
        if(depth == n) {
            if(Integer.parseInt(cur) > Integer.parseInt(s)) {
                answer = Math.min(answer, Integer.parseInt(cur));
                return;
            }
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTracking(cur + arr[i], depth+1);
                visited[i] = false;
            }
        }
    }
}