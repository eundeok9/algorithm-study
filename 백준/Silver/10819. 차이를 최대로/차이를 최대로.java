import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int answer;
    static int[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        order = new int[N];
        backTracking(0);
        System.out.println(answer);
    }

    public static void backTracking(int depth) {
        if(depth == N) {
            int sum = 0;
            for(int i=0; i<N-1; i++) {
                sum += Math.abs(order[i] - order[i+1]);
            }
            answer = Math.max(sum, answer);
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                order[depth] = arr[i];
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}