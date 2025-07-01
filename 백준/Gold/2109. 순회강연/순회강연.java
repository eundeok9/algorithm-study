import java.io.*;
import java.util.*;
public class Main {
    static class Lecture implements Comparable<Lecture> {
        int pay, day;

        Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture lec) {
            if (this.pay == lec.pay) {
                return lec.day - this.day;
            }
            return lec.pay - this.pay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            max = Math.max(max, d);
            lectures[i] = new Lecture(p, d);
        }

        Arrays.sort(lectures);


        boolean[] checked = new boolean[max + 1];
        int result = 0;
        for (Lecture lec : lectures) {
            for (int i = lec.day; i > 0; i--) {
                if (!checked[i]) {
                    checked[i] = true;
                    result += lec.pay;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}