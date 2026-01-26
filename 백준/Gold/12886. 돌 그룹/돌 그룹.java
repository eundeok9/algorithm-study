import java.io.*;
import java.util.*;
public class Main {
    static boolean[][] visited;
    static int sum = 0;
    static class Stone {
        int a, b;
        Stone(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        sum = a + b + c;

        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }

        Queue<Stone> queue = new LinkedList<>();
        queue.offer(new Stone(a, b));

        visited = new boolean[1001][1001];
        visited[a][b] = true;

        while(!queue.isEmpty()) {
            Stone cur = queue.poll();

            a = cur.a;
            b = cur.b;
            c = sum - (a+b);

            if(a==b && b==c) {
                System.out.println(1);
                return;
            }

            if(a!=b) {
                int na = a > b ? a-b : a+a;
                int nb = a > b ? b+b : b-a;

                if(na <= 1000 && nb <= 1000 && !visited[na][nb]) {
                    queue.offer(new Stone(na, nb));
                    visited[na][nb] = true;
                }
            }

            if(a!=c) {
                int na = a > c ? a-c : a+a;
                int nc = a > c ? c+c : c-a;

                if(na <= 1000 && nc <= 1000 && !visited[na][nc]) {
                    queue.offer(new Stone(na, nc));
                    visited[na][nc] = true;
                }
            }
        }

        System.out.println(0);
    }
}
