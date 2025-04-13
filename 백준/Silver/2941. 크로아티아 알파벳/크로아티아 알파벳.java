import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());

        String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String alph: alphabet) {
            int idx = s.indexOf(alph);
            while(idx != -1) {
                s.replace(idx, idx + alph.length(), "A");

                idx = s.indexOf(alph, idx + 1);
            }
        }

        System.out.println(s.length());
    }
}