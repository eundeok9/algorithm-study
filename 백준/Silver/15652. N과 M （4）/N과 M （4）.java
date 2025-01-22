import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backTracking(0, 1);
        System.out.println(sb);
    }

    public static void backTracking(int depth, int start) {
        if (depth == M) {
            for (int i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            list.add(i);
            backTracking(depth + 1, i);
            list.remove(list.size() - 1);
        }
    }
}