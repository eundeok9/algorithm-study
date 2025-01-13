import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int zero = 0;
        int one = 0;

        char ch = s.charAt(0);
        if(ch=='0') {
            zero++;
        } else {
            one++;
        }

        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) != ch) {
                ch = s.charAt(i);
                if(ch == '1') one++;
                else zero++;
            }
        }

        System.out.println(Math.min(zero, one));
    }
}