import java.io.*;
import java.util.*;
public class Main {
    static String s;
    static List<Integer> result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        visited = new boolean[51];
        backTracking(0, new ArrayList<>());

        StringBuilder sb = new StringBuilder();
        for(Integer num: result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    static void backTracking(int idx, List<Integer> current) {
        if(idx == s.length()) {
            if(isValid(current)) {
                result = new ArrayList<>(current);
                return;
            }
        }

        // 한자리수 시도
        if(idx < s.length()) {
            int num = s.charAt(idx) - '0';
            if(num >= 1 && !visited[num]) {
                visited[num] = true;
                current.add(num);
                backTracking(idx + 1, current);
                current.remove(current.size() - 1);
                visited[num] = false;
            }
        }

        // 두자리수 시도
        if(idx + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(idx, idx+2));
            if(num >= 1 && num <= 50 && !visited[num]) {
                visited[num] = true;
                current.add(num);
                backTracking(idx + 2, current);
                current.remove(current.size() - 1);
                visited[num] = false;
            }
        }
    }

    // 1부터 N까지의 순열인가?
    static boolean isValid(List<Integer> list) {
        int max = 0;
        for(int num: list) {
            max = Math.max(max, num);
        }

        // 중복 체크
        boolean[] check = new boolean[max+1];
        for(int num: list) {
            if(num < 1 || num > max || check[num]) {
                return false;
            }
            check[num] = true;
        }

        // 모든 수가 1~max까지 포함?
        for(int i=1; i<=max; i++) {
            if(!check[i]) return false;
        }

        return true;
    }
}