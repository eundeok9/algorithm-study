import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        int[][] map = new int[N][N];
        
        HashMap<String, Integer> friendMap = new HashMap<>();
        for(int i=0; i<N; i++) {
            friendMap.put(friends[i], i);
        }
        
        for(int i=0; i<gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            
            String from = st.nextToken();
            String to = st.nextToken();
            
            int r = friendMap.get(from);
            int c = friendMap.get(to);
            
            map[r][c]++;
        }
        
        int[] giveCnt = new int[N]; // 선물을 준 개수
        int[] getCnt = new int[N]; // 선물을 받은 개수
        
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<N; j++) {
                sum += map[i][j];
            }
            giveCnt[i] = sum;
        }
        
        for(int j=0; j<N; j++) {
            int sum = 0;
            for(int i=0; i<N; i++) {
                sum += map[i][j];
            }
            getCnt[j] = sum;
        }
        
        
        int[] present = new int[N];
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(map[i][j] != map[j][i]) {
                    if(map[i][j] > map[j][i]) {
                        present[i]++;   
                    } else if(map[i][j] < map[j][i]) {
                        present[j]++;
                    }
                } else if (map[i][j] == map[j][i]) {
                    int scoreI = giveCnt[i] - getCnt[i];
                    int scoreJ = giveCnt[j] - getCnt[j];
                    if(scoreI > scoreJ) {
                        // i의 선물지수가 더 클 때
                        present[i]++;
                    } else if(scoreI < scoreJ) {
                        present[j]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<N; i++) {
            answer = Math.max(present[i], answer);
        }
        
        return answer;
    }
}