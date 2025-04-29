import java.io.*;
import java.util.*;
public class Main {
    static class Lecture {
        int start, end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (o1, o2) -> {
            return Integer.compare(o1.start, o2.start);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int room = 0;

        for(Lecture lec: lectures) {
            int start = lec.getStart();
            int end = lec.getEnd();

            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);

            room = Math.max(room, pq.size());
        }

        System.out.println(room);
    }
}