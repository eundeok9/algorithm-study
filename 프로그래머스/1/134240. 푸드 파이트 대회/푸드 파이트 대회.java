class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        // 왼쪽부터 먹을 음식 배치
        for(int i=1; i<food.length; i++) {
            int cnt = food[i] / 2;
            sb.append(String.valueOf(i).repeat(cnt));
        }
        
        // 물 추가
        String answer = sb + "0";
        
        // 오른쪽부터 먹을 음식 배치
        answer += sb.reverse();
        
        return answer;
    }
}