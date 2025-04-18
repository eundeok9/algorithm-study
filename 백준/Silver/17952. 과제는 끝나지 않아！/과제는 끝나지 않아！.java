import java.io.*;
import java.util.*;
public class Main {
    public static class Homework {
        int score;
        int time;

        public Homework(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Homework> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) {
                if(!stack.isEmpty()) {
                    Homework temp = stack.pop();
                    temp.time--;
                    if (temp.time == 0) {
                        answer += temp.score;
                    } else {
                        stack.push(temp);
                    }
                }
            } else {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                if(time == 1) {
                    answer += score;
                } else {
                    stack.push(new Homework(score, time - 1));
                }
            }
        }
        System.out.println(answer);
    }
}