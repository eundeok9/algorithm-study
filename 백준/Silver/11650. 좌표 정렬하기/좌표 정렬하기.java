import java.io.*;
import java.util.*;

public class Main {
    public static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }

            return Integer.compare(this.x, o.x);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        Collections.sort(points);

        StringBuilder sb = new StringBuilder();
        for(Point p: points) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.println(sb);
    }
}
