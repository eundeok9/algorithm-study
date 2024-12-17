import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            Deque<Integer> deque = new ArrayDeque<>();

            for(int i=0; i<N; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(command, deque);

        }
        System.out.println(sb);
    }

    public static void AC(String command, Deque<Integer> deque) {
        boolean isRight = false;

        for(char cmd: command.toCharArray()) {
            if(cmd == 'R') {
                isRight = !isRight;
            } else {
                if(deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                } else {
                    if(isRight) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }
        }

        sb.append("[");
        if(!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size - 1; i++) {
                sb.append(isRight ? deque.removeLast() : deque.removeFirst()).append(",");
            }
            sb.append(deque.remove());
        }
        sb.append("]\n");
    }
}
