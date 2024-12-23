import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited, done;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            done = new boolean[N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num - 1;
            }

            count = 0;
            for(int i=0; i<N; i++) {
                if(!done[i]) {
                    dfs(i);
                }
            }
            sb.append(N - count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n) {
        if(visited[n]) {
            done[n] = true;
            count++;
        } else {
            visited[n] = true;
        }

        if(!done[arr[n]]) {
            dfs(arr[n]);
        }

        visited[n] = false;
        done[n] = true;
    }
}
