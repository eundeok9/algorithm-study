import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int num: answer) {
            System.out.println(num);
        }
    }

    public static void dfs(int start, int target) {
        if(!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }
        if(arr[start] == target) answer.add(target);
    }
}