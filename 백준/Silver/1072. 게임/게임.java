import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        int Z = (int) ((Y * 100) / X);

        if(Z >= 99) {
            System.out.println(-1);
            return;
        }

        long min = 1;
        long max = X;
        long answer = -1;
        while(min <= max) {
            long mid = (min + max) / 2;
            long newX = mid + X;
            long newY = mid + Y;
            if((int) ((newY * 100) / newX) > Z) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
