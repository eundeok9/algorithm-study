import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int mp, mf, ms, mv;
    static int[][] gradient;
    static int minPrice = Integer.MAX_VALUE;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        gradient = new int[N][5];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                gradient[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        backTracking(0, 0, 0, 0, 0, 0, new ArrayList<>());
       
        if(answer.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(minPrice);
            for (int i : answer) {
                System.out.print(i + " ");
            }
        }
    }

    public static void backTracking(int start, int p, int f, int s, int v, int price, ArrayList<Integer> list) {
        if(price >= minPrice) return;

        if(p >= mp && f >= mf && s >= ms && v >= mv) {
            minPrice = price;
            answer = new ArrayList<>(list);
            return;
        }

        for(int i=start; i<N; i++) {
            int[] cur = gradient[i];
            list.add(i+1);
            backTracking(i+1, p + cur[0], f + cur[1], s + cur[2], v + cur[3], price + cur[4], list);
            list.remove(list.size() - 1);
        }
    }
}