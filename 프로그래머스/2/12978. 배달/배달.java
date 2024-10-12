class Solution {
    
    static final int INF = 500001;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] map = new int[N+1][N+1]; // 간선 정보 저장
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) continue;
                map[i][j] = INF;
            }
        }
        
        for(int i=0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            
            if(map[a][b] > w) {
                map[a][b] = w;
                map[b][a] = w;
            }
        }
        
        // 거리 정보 저장
        int[] dist = new int[N+1];
        for(int i=2; i<=N; i++) {
            dist[i] = INF;
        }
        
        // 방문 정보 저장
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        
        for(int i=1; i<N ; i++) {
            int min_idx = 1;
            int min_value = INF;
            
            // 가장 가까운 노드 찾기
            for(int j=2; j<=N; j++) {
                if(!visited[j] && dist[j] < min_value) {
                    min_value = dist[j];
                    min_idx = j;
                }
            }
            
            visited[min_idx] = true;
            
            // 돌아가는 루트가 더 빠른지 확인
            for(int j=2; j<=N; j++) {
                if (dist[j] > dist[min_idx] + map[min_idx][j]) {
                    dist[j] = dist[min_idx]+map[min_idx][j];
                }
            }
            
        }
        
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
}