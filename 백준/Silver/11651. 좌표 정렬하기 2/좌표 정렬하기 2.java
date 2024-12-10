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
            if(o.y == this.y) {
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y); // 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(Point p: list) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.println(sb);
    }
}
