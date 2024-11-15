class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // 번호 일치 횟수에 따른 순위
        
        for(int num: lottos) {
            if(num == 0) {
                answer[0]++;
                continue;
            }
            
            for(int win_num: win_nums) {
                if(num == win_num) {
                    answer[1]++;
                }
            }
            
        }
        
        answer[0] = rank[answer[0] + answer[1]];
        answer[1] = rank[answer[1]];
        
        return answer;
    }
}