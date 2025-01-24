import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = 0;
        int ioiCnt = 0;
        for(int i=1; i<M-1; i++) {
            if(s.charAt(i-1) == 'I' && s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
                ioiCnt++;

                if(ioiCnt == N) {
                    ioiCnt--;
                    answer++;
                }
                i++;

            } else {
                ioiCnt = 0;
            }
        }

        System.out.println(answer);
    }
}