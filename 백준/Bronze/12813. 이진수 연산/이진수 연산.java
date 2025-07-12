import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int len = A.length;

        StringBuilder and = new StringBuilder(len);
        StringBuilder or = new StringBuilder(len);
        StringBuilder xor = new StringBuilder(len);
        StringBuilder notA = new StringBuilder(len);
        StringBuilder notB = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            char a = A[i];
            char b = B[i];

            // AND
            and.append((a == '1' && b == '1') ? '1' : '0');

            // OR
            or.append((a == '1' || b == '1') ? '1' : '0');

            // XOR
            xor.append((a != b) ? '1' : '0');

            // NOT A
            notA.append((a == '1') ? '0' : '1');

            // NOT B
            notB.append((b == '1') ? '0' : '1');
        }

        System.out.println(and);
        System.out.println(or);
        System.out.println(xor);
        System.out.println(notA);
        System.out.println(notB);
    }
}
