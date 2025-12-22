class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = players.length;
        
        int[] serverStatus = new int[n];
        
        for(int i=0; i<n; i++) {
            if(players[i] >= m) {
                int serverCnt = players[i] / m; // 증설해야하는 서버 수
                if(serverStatus[i] < serverCnt) { // 증설된 서버수로 감당이 안된다면
                    int need = serverCnt - serverStatus[i];
                    answer += need;
                    for (int t = i; t < Math.min(n, i + k); t++) {
                        serverStatus[t] += need;
                    }
                }
            }
        }
        
        return answer;
    }
}