import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 0;
        for(int i=0; i<N-1; i++) {
            if(s.charAt(i) == 'E' && s.charAt(i+1) == 'W') {
                count++;
            }
        }

        System.out.println(count);
    }
}