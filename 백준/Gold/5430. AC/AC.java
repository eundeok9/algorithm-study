import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static ArrayDeque<String> deque;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            // 입력값 처리
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] sarr = s.substring(1, s.length() - 1).split(",");
            deque = new ArrayDeque<>();
            for(int i=0; i<n; i++) {
                deque.add(sarr[i]);
            }

            // AC 실행
            AC(cmd);
        }
        System.out.println(sb);
    }

    public static void AC(String cmd) {
        boolean isReverse = false;

        for(char c: cmd.toCharArray()) {
            if(c == 'R') isReverse = !isReverse;

            else {
                if(deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                }
                if(isReverse) deque.removeLast();
                else deque.removeFirst();
            }
        }
        sb.append("[");
        int size = deque.size();
        for(int i=0; i<size-1; i++) {
            sb.append(isReverse ? deque.removeLast() : deque.removeFirst()).append(",");
        }
        if(size > 0) {
            sb.append(deque.remove());
        }
        sb.append("]\n");
    }
}
