import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        for(int i=0; i<N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=N-2; i>=0; i--) {
            if(score[i+1] <= score[i]) {
                int tmp = score[i+1] - 1;
                answer += score[i] - tmp;
                score[i] = tmp;
            }
        }

        System.out.println(answer);
    }
}