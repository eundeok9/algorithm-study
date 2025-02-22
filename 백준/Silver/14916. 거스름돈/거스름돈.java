import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int fiveCnt = n / 5;
        int answer = -1;
        for(int i=fiveCnt; i>=0; i--) {
            int remain = n - i * 5;
            if(remain % 2 == 0) {
                answer = i + (remain / 2);
                break;
            }
        }
        System.out.println(answer);
    }
}