import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        HashSet<Integer> twoSum = new HashSet<>();
        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                twoSum.add(arr[i] + arr[j]);
            }
        }

        // d-c = a+b
        for(int i=N-1; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                int d = arr[i];
                int c = arr[j];
                int target = d-c;

                if(twoSum.contains(target)) {
                    System.out.println(d);
                    return;
                }
            }
        }
    }
}