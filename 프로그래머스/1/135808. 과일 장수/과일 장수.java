import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int box = score.length / m;
    
        Arrays.sort(score);

        for(int i=1; i<=box; i++) {
            answer += score[score.length - m * i] * m;
        }
        
        return answer;
    }
}