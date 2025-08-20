import java.io.*;
public class Main {
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            N = Integer.parseInt(br.readLine());

            answer = 0;
            backTracking(0);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void backTracking(int sum) {
        if(sum > N) return;
        if(sum == N) {
            answer++;
        }

        for(int i=1; i<=3; i++) {
            backTracking(sum + i);
        }
    }
}