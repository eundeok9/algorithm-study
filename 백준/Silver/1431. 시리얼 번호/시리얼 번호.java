import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }

                int sumA = getDigitSum(o1);
                int sumB = getDigitSum(o2);
                if(sumA != sumB) {
                    return sumA - sumB;
                }

                return o1.compareTo(o2);
            }
        });

        for(String s: arr) {
            System.out.println(s);
        }
    }

    static int getDigitSum(String s) {
        int sum = 0;
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                sum += c - '0';
            }
        }

        return sum;
    }
}