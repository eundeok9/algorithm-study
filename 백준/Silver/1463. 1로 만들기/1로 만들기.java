import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] visited = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;
        while(!queue.isEmpty()) {
            int x = queue.poll();

            if(x == 1) {
                System.out.println(visited[x]-1);
                break;
            }

            if(x % 3 == 0 && visited[x/3] == 0) {
                visited[x/3] = visited[x] + 1;
                queue.add(x/3);
            }
            if(x % 2 == 0 && visited[x/2] == 0) {
                visited[x/2] = visited[x] + 1;
                queue.add(x/2);
            }
            if(visited[x-1] == 0) {
                visited[x-1] = visited[x] + 1;
                queue.add(x-1);
            }
        }
    }
}
