import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] count = new int[3];
        
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++) {
            if(first[i%5] == answers[i]) {
                count[0] += 1;
            }
            if(second[i%8] == answers[i]) {
                count[1] += 1;
            }
            if(third[i%10] == answers[i]) {
                count[2] += 1;
            }
        }
        
        int maxScore = 0;
        for(int score: count) {
            if(maxScore < score) {
                maxScore = score;
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(maxScore == count[i]) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}