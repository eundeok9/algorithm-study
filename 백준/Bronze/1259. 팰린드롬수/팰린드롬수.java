import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();
            if(s.equals("0")) break;

            boolean flag = true;

            for(int i=0; i<s.length()/2; i++) {
                if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}