import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];        
        
        // 명예의 전당
        ArrayList<Integer> rank = new ArrayList<>();
        
        for(int i=0; i<score.length; i++) {
            rank.add(score[i]);
            
            
            Collections.sort(rank);
            
            if(rank.size() > k) {
                rank.remove(rank.get(0));
            }
            
            answer[i] = rank.get(0);
        }
        
        return answer;
    }
}