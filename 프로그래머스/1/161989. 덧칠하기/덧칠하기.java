class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int start = section[0];
        int end = start + m - 1;
        
        for(int i=0; i<section.length; i++) {
            if(start <= section[i] && section[i] <= end) {
                continue;
            } else {
                start = section[i];
                end = start + m - 1;
                answer++;
            }
        }     
        
        return answer;
    }
}