import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();

        for(int i=2; i>=0; i--) {
            String s = String.valueOf(b.charAt(i));
            System.out.println(a * Integer.parseInt(s));
        }
        System.out.println(a * Integer.parseInt(b));

    }
}