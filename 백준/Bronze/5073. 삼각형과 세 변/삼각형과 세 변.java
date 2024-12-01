import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] ar = new int[3];

        while(true) {
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<3; i++) {
                ar[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ar);

            if(ar[0] == 0) {
                break;
            }

            if(ar[2] >= ar[0] + ar[1]) {
                System.out.println("Invalid");
            } else if(ar[0] == ar[1] && ar[1] == ar[2]) {
                System.out.println("Equilateral");
            } else if (ar[0] == ar[1] || ar[1] == ar[2] || ar[0] == ar[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }

        }
    }
}
