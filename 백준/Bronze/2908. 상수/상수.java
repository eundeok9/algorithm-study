import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        StringBuilder reverseA = new StringBuilder();
        StringBuilder reverseB = new StringBuilder();
        for(int i=2; i>=0; i--) {
            reverseA.append(a.charAt(i));
            reverseB.append(b.charAt(i));
        }

        if(Integer.parseInt(reverseB.toString()) > Integer.parseInt(reverseA.toString())) {
            System.out.println(reverseB);
        } else {
            System.out.println(reverseA);
        }
    }
}