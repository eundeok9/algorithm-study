class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++) {
            int schedule = schedules[i] + 10;
            // ex) 655 -> 665가 되는 경우 705로 바꿔줘야함.
            if(schedule % 100 >= 60) {
                int time = schedule / 100;
                int minute = schedule % 100;
                int extraTime = minute / 60;
                minute %= 60;
                schedule = (time + extraTime) * 100 + minute;
            }
            int cnt = 0;
            for(int j=0; j<7; j++) {
                int time = timelogs[i][j];
                if(1<=startday && startday <= 5 && time <= schedule) {
                    cnt++;
                }
                startday++;
                if(startday > 7) {
                    startday = 1;
                }
            }
            if(cnt >= 5) {
                answer++;
            }
        }
        return answer;
    }
}