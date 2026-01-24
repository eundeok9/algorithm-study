import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int maxCount = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N];

            queue.add(i);
            visited[i] = true;

            int depth = 0;
            int count = 0;

            while(depth < 2) {
                int size = queue.size();

                for(int j=0; j<size; j++) {
                    int n = queue.poll();

                    for(int k=0; k<N; k++) {
                        if(map[n][k] == 'Y' && !visited[k]) {
                            queue.add(k);
                            count++;
                            visited[k] = true;
                        }
                    }
                }
                depth++;
            }
            if(maxCount < count) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);
    }
}