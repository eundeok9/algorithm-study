import java.io.*;
import java.util.*;
public class Main {
    static class Homework implements Comparable<Homework> {
        int day, work;
        Homework(int day, int work) {
            this.day = day;
            this.work = work;
        }

        @Override
        public int compareTo(Homework o) {
            if(o.work == this.work) {
                return o.day - this.day;
            }
            return o.work - this.work;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int max = 0;
        Homework[] homeworks = new Homework[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            max = Math.max(max, d);
            homeworks[i] = new Homework(d, w);
        }

        Arrays.sort(homeworks);

        int result = 0;
        boolean[] checked = new boolean[max+1];
        for(Homework homework: homeworks) {
            for(int i=homework.day; i>0; i--) {
                if(!checked[i]) {
                    checked[i] = true;
                    result += homework.work;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}