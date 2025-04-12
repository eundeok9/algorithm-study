import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDays = 0;
        for(int i=0; i<month-1; i++) {
            totalDays += dayOfMonth[i];
        }

        totalDays += day;

        int index = (totalDays - 1) % 7;
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        System.out.println(week[index]);
    }
}