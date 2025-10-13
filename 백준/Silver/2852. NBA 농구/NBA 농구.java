import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int lastIdx = 0;
        int[][] data = new int[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = stringToTime(st.nextToken());
        }

        int aScore = 0;
        int bScore = 0;
        int aTime = 0;
        int bTime = 0;

        for(int i=0; i<2880; i++) {
            if(lastIdx < n && data[lastIdx][1] == i) {
                if(data[lastIdx][0] == 1) aScore++;
                else bScore++;
                lastIdx++;
            }

            if(aScore > bScore) aTime++;
            else if(aScore < bScore) bTime++;
        }

        System.out.println(timeToString(aTime));
        System.out.println(timeToString(bTime));
    }

    static int stringToTime(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    static String timeToString(int time) {
        return (time / 60 < 10 ? "0" : "") + time / 60 + ":" + (time % 60 < 10 ? "0" : "") + time % 60;
    }
}