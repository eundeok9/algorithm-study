import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        int[][] map = new int[N][N];
        
        HashMap<String, Integer> friendMap = new HashMap<>();
        for(int i=0; i<N; i++) {
            friendMap.put(friends[i], i);
        }
        
        int[] score = new int[N]; // 선물 지수
        
        for(int i=0; i<gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            int from = friendMap.get(st.nextToken());
            int to = friendMap.get(st.nextToken());
            
            score[from]++;
            score[to]--;
            
            map[from][to]++;
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
                    if(score[i] > score[j]) {
                        // i의 선물지수가 더 클 때
                        present[i]++;
                    } else if(score[i] < score[j]) {
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