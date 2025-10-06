import java.io.*;
import java.util.*;
public class Main {
    static class Country implements Comparable<Country> {
        int num, g, s, b;

        Country(int num, int g, int s, int b) {
            this.num = num;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        public int compareTo(Country o) {
            if(o.g != this.g) {
                return o.g - this.g;
            } else if(o.s != this.s) {
                return o.s - this.s;
            }
            return o.b - this.b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Country(num, g, s, b));
        }

        Collections.sort(list);

        int rank = 1;
        int[] ranks = new int[N];
        ranks[0] = 1;

        for (int i = 1; i < N; i++) {
            Country prev = list.get(i - 1);
            Country cur = list.get(i);

            if (cur.g == prev.g && cur.s == prev.s && cur.b == prev.b) {
                ranks[i] = ranks[i - 1]; // 동순위
            } else {
                ranks[i] = i + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (list.get(i).num == K) {
                System.out.println(ranks[i]);
                break;
            }
        }
    }
}