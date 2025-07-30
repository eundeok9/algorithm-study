import java.io.*;
import java.util.*;
public class Main {
    static class Pair implements Comparable<Pair>{
        double time;
        int index;

        Pair(double time, int index) {
            this.time = time;
            this.index = index;
        }

        public int compareTo(Pair o) {
            if(this.time == o.time) {
                return this.index - o.index;
            };
            return Double.compare(this.time, o.time);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Pair[] parr = new Pair[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            double d = Math.sqrt(Math.pow(x,2)+ Math.pow(y, 2)); // 원점에서의 거리
            parr[i] = new Pair(d/v, i+1);
        }

        Arrays.sort(parr);

        for(Pair p: parr) {
            System.out.println(p.index);
        }
    }
}