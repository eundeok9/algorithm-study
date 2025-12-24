import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1}); // 시간 0초, 클립보드 0개, 화면 1개
        visited = new boolean[2001][2001];

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int time = cur[0];
            int clip = cur[1];
            int screen = cur[2];

            if(screen == N) return time;

            if(!visited[screen][screen]) { // 현재 화면을 클립보드에 복사
                visited[screen][screen] = true;
                queue.offer(new int[]{time + 1, screen, screen});
            }

            if(clip > 0 && screen + clip <= 2000 && !visited[clip][screen+clip]) { // 붙여넣기
                visited[clip][screen+clip] = true;
                queue.offer(new int[] {time+1, clip, screen+clip});
            }

            if(screen - 1 > 0 && !visited[clip][screen-1]) {
                visited[clip][screen-1] = true;
                queue.offer(new int[] {time+1, clip, screen-1});
            }
        }

        return -1;
    }
}
