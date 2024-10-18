class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        answer = health - attacks[0][1];
        for(int i=1; i<attacks.length; i++) {
            int time = attacks[i][0] - attacks[i-1][0] - 1;
            int damage = attacks[i][1];
            
            answer += time * bandage[1] + time / bandage[0] * bandage[2];
            if(answer > health) {
                answer = health;
            }
            
            answer -= damage;
            
            if(answer <= 0) {
                return -1;
            }
        }
        
        return answer;
    }
}