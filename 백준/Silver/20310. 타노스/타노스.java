import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<zeroCnt/2; i++) {
            sb.append(0);
        }
        for(int i=0; i<oneCnt/2; i++) {
            sb.append(1);
        }

        System.out.println(sb);
    }
}
