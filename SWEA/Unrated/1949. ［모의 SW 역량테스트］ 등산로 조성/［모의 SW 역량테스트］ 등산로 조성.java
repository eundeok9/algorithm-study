import java.io.*;
import java.util.*;

class Solution
{
	    static int N, K;
    static int[][] map;
    static int[][] visited;
    // 사방탐색을 위한 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxLength; // 가장 긴 등산로

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int tc = Integer.parseInt(br.readLine());
        // 테스트케이스 수 만큼 반복
        for(int t=0; t<tc; t++) {
            // 입력값 처리
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new int[N][N];
            int maxHeight = Integer.MIN_VALUE;
            maxLength = Integer.MIN_VALUE;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(map[i][j], maxHeight); // 가장 높은 봉우리 찾기
                }
            }

            // 가장 높은 봉우리인 곳 찾아서 가장 긴 등산로 찾기
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] == maxHeight) {
                        visited[i][j] = 1;
                        dfs(i, j, 1);
                        visited[i][j] = 0;
                    }
                }
            }
            sb.append("#").append(t+1).append(" ").append(maxLength).append("\n");

        }
        System.out.println(sb);
    }

    public static void dfs(int startX, int startY, int kCount) {
        if(maxLength < visited[startX][startY]) {
            maxLength = visited[startX][startY];
        }

        for(int d=0; d<4; d++) {
            int nx = startX + dx[d];
            int ny = startY + dy[d];

            if(check(nx, ny) || visited[nx][ny] > 0) continue;
            if(map[nx][ny] < map[startX][startY]) {
                visited[nx][ny] = visited[startX][startY] + 1;
                dfs(nx, ny, kCount);
                visited[nx][ny] = 0;
            } else if(kCount == 1 && map[nx][ny] - K < map[startX][startY]) {
                int tmp = map[nx][ny];
                visited[nx][ny] = visited[startX][startY] + 1;
                map[nx][ny] = map[startX][startY] - 1;
                dfs(nx, ny, 0);
                visited[nx][ny] = 0;
                map[nx][ny] = tmp;
            }
        }
    }

    public static boolean check(int x, int y) {
        return !(0<=x && x <N && 0<=y && y<N);
    }
}