import java.io.*;
import java.util.*;
public class Main {
    static class Score implements Comparable<Score> {
        String name;
        int kor,eng,math;

        Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public int compareTo(Score o) {
            if(o.kor != this.kor) {
                return o.kor-this.kor;
            } else if(this.eng != o.eng) {
                return this.eng - o.eng;
            } else if(this.math != o.math) {
                return o.math - this.math;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Score[] scores = new Score[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            scores[i] = new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(scores);

        StringBuilder sb = new StringBuilder();
        for(Score score: scores) {
            sb.append(score.name).append("\n");
        }
        System.out.println(sb);
    }
}