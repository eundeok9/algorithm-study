import java.io.*;
import java.util.*;
public class Main {
    public static class Lecture {
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

        int N = Integer.parseInt(br.readLine());
        ArrayList<Lecture> lectures = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 강의 번호 무시
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }

        Collections.sort(lectures, (a, b) -> Integer.compare(a.getStart(), b.getStart()));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료 시간 관리
        int room = 0;

        for(Lecture lec: lectures) {
            int start = lec.getStart();
            int end = lec.getEnd();

            // 사용 가능한 강의실이 있다면 재사용
            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            // 현재 강의의 종료시간 추가
            pq.offer(end);

            // 동시에 사용 중인 강의실 수 갱신
            room = Math.max(room, pq.size());
        }

        System.out.println(room);
    }
}