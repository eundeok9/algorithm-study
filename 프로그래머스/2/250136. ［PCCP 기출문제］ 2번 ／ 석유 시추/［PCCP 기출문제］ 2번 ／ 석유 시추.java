import java.util.*;

class Solution {
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int[] oil; // 시추관 위치별 석유량
    
    public static class Node {
        int x, y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        
        oil = new int[M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
        
        for(int i=0; i<oil.length; i++) {
            answer = Math.max(answer, oil[i]);
        }
        return answer;
    }
    
    public static void bfs(int i, int j, int[][] land) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        visited[i][j] = true;
        
        // 석유 덩어리 개수
        int count = 1;
        // 석유 덩어리 열 위치
        Set<Integer> set = new HashSet<>();
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            set.add(y);
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(check(nx, ny)) continue;
                if(!visited[nx][ny] && land[nx][ny] != 0) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        
        for(int index: set) {
            oil[index] += count;
        }
        
    }
    
    public static boolean check(int x, int y) {
        return 0 > x || x >= N || 0 > y || y >= M;
    }
}