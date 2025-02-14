import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[2000001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            visited[arr[i]] = true;
        }

        backTracking(0,0);

        for(int i=1; i<=visited.length; i++) {
            if(!visited[i]) {
                System.out.println(i);
                return;
            }
        }

    }

    public static void backTracking(int start, int sum) {
        if(!visited[sum]) {
            visited[sum] = true;
        }

        for(int i=start; i<N; i++) {
            backTracking(i+1, sum + arr[i]);
        }
    }
}