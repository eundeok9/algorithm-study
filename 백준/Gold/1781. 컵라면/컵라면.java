import java.io.*;
import java.util.*;
public class Main {
    static class Problem implements Comparable<Problem> {
        int time, ramen;

        Problem(int time, int ramen) {
            this.time = time;
            this.ramen = ramen;
        }

        public int compareTo(Problem o) {
            if(this.time == o.time) {
                return o.ramen - this.ramen;
            }
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Problem> problems = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            problems.offer(new Problem(t, r));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(!problems.isEmpty()) {
            Problem problem = problems.poll();
            int time = problem.time;
            int ramen = problem.ramen;

            if(pq.size() < time) {
                pq.offer(ramen);
            } else {
                if(pq.peek() < ramen) {
                    pq.poll();
                    pq.offer(ramen);
                }
            }
        }

        long answer = 0L;
        for(Integer ramen: pq) {
            answer += ramen;
        }
        System.out.println(answer);
    }
}
