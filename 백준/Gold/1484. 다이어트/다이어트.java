import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());

        int prev = 1; // 기억하고 있는 무게
        int cur = 1; // 현재 무게
        boolean found = false;

        while(true) {
//            System.out.println(prev  + " " + cur);
            long diff = (long) cur*cur - (long) prev*prev;

            if(diff == G) {
                System.out.println(cur);
                found = true;
            }

            if(diff > G) prev++;
            else cur++;

            if(prev == cur) continue;
            if(cur > 100000) break;
        }

        if(!found) System.out.println(-1);
    }
}