class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekdays = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}; // 금요일부터 시작
        
        // a월 b일까지 총 몇 일인지
        int totalDays = 0;
        for(int i=0; i<a-1; i++) {
            totalDays += days[i];
        }
        totalDays += b - 1;
        
        return weekdays[totalDays % 7];
    }
}