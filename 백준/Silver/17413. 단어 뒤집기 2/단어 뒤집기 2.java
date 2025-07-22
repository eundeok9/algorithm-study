import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < s.length()) {
            if(s.charAt(idx) == '<') {
                while(s.charAt(idx) != '>') {
                    sb.append(s.charAt(idx));
                    idx++;
                }
                sb.append(s.charAt(idx));
                idx++;
            } else if(s.charAt(idx) == ' ') {
                sb.append(' ');
                idx++;
            } else {
                StringBuilder tmpStr = new StringBuilder();
                while(idx < s.length() && s.charAt(idx) != '<' && s.charAt(idx) != ' ') {
                    tmpStr.append(s.charAt(idx));
                    idx++;
                }
                sb.append(tmpStr.reverse());
            }
        }
        System.out.println(sb);
    }
}