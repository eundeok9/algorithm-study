import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);

        StringBuilder s = new StringBuilder();
        for(char c: arr) {
            s.append(c);
        }

        System.out.println(s.reverse());
    }
}