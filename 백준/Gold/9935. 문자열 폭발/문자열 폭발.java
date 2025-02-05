import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String bomb = br.readLine();
        int bLength = bomb.length();

        for(char ch: s.toCharArray()) {
            sb.append(ch);

            if(sb.length() >= bLength) {
                if(sb.substring(sb.length() - bLength).equals(bomb)) {
                   sb.delete(sb.length() - bLength, sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}