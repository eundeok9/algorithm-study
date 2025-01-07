import java.io.*;
import java.util.*;
public class Main {
    static class Register {
        int num;
        String command;

        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int D() {
            return (num * 2) % 10000;
        }

        int S() {
            return num == 0 ? 9999 : num - 1;
        }

        int L() {
            return num % 1000 * 10 + num / 1000;
        }

        int R() {
            return num % 10 * 1000 + num /10;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000];
            visited[A] = true;

            Queue<Register> queue = new LinkedList<>();
            queue.add(new Register(A, ""));

            while(!queue.isEmpty()) {
                Register cur = queue.poll();

                if(cur.num == B) {
                    sb.append(cur.command).append("\n");
                    break;
                }

                if(!visited[cur.D()]) {
                    queue.add(new Register(cur.D(), cur.command + "D"));
                    visited[cur.D()] = true;
                }
                if(!visited[cur.S()]) {
                    queue.add(new Register(cur.S(), cur.command + "S"));
                    visited[cur.S()] = true;
                }
                if(!visited[cur.L()]) {
                    queue.add(new Register(cur.L(), cur.command + "L"));
                    visited[cur.L()] = true;
                }
                if(!visited[cur.R()]) {
                    queue.add(new Register(cur.R(), cur.command + "R"));
                    visited[cur.R()] = true;
                }
            }
        }
        System.out.println(sb);
    }
}