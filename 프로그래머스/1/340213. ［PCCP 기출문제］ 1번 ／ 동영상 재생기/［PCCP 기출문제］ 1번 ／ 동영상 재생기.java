class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoTime = convertTime(video_len);
        int curTime = convertTime(pos);
        int opStartTime = convertTime(op_start);
        int opEndTime = convertTime(op_end);
        
        if(opStartTime <= curTime && curTime <= opEndTime) {
            curTime = opEndTime;
        }
        
        for(String command: commands) {
            if(command.equals("prev")) {
                if(curTime < 10) {
                    curTime = 0;
                } else {
                    curTime -= 10;
                }
            } else {
                if(curTime + 10 >= videoTime) {
                    curTime = videoTime;
                } else {
                    curTime += 10;
                }
            }
            
            if(opStartTime <= curTime && curTime <= opEndTime) {
                curTime = opEndTime;
            }
        }
        
        String min = curTime / 60 < 10 ? "0" + String.valueOf(curTime/60) : String.valueOf(curTime/60);
        String sec = (curTime % 60 >= 10) ? String.valueOf(curTime % 60) : (curTime % 60 > 0) ? "0" + String.valueOf(curTime % 60) : "00";
        answer = min + ":" + sec;
        
        return answer;
    }
    
    static public int convertTime(String s) {
        return Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
    }
}