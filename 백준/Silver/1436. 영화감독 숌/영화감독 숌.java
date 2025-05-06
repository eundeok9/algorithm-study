import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 1;
        int number = 666;
        while(count != n) {
            number++;
            if(String.valueOf(number).contains("666")) {
                count++;
            }
        }
        System.out.println(number);
    }
}
