import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] popularity; // 인구 수
    static List<List<Integer>> graph;
    static boolean[] selected;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 인구수 저장
        popularity = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            popularity[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        // 인접 리스트 저장
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        selected = new boolean[N];
        backTracking(0);

        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void backTracking(int idx) {
        if(idx == N) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for(int i=0; i<N; i++) {
                if(selected[i]) {
                    a.add(i);
                } else {
                    b.add(i);
                }
            }
            // 한 선거구로 몰렸을 경우
            if(a.isEmpty() || b.isEmpty()) {
                return;
            }

            // 두 지역구가 선거구 조건을 만족하는지
            if(bfs(a) && bfs(b)) {
                // 인구수 차이 구하기
                calc();
            }
            return;
        }

        selected[idx] = true;
        backTracking(idx+1);
        selected[idx] = false;
        backTracking(idx+1);
    }

    public static boolean bfs(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N];
        visited[list.get(0)] = true;
        queue.add(list.get(0));

        int count = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i=0; i<graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if(list.contains(next) && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count == list.size();
    }

    public static void calc() {
        int aSum = 0;
        int bSum = 0;
        for(int i=0; i<N; i++) {
            if(selected[i]) {
                aSum += popularity[i];
            } else {
                bSum += popularity[i];
            }
        }

        int diff = Math.abs(aSum - bSum);
        answer = Math.min(diff, answer);
    }
}
