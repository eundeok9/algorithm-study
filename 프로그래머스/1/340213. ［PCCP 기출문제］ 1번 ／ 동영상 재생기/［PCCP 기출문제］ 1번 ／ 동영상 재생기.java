class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoTime = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int curTime = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int opStartTime = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int opEndTime = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        
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
            // System.out.println(curTime);
        }
        
        String min = curTime / 60 < 10 ? "0" + String.valueOf(curTime/60) : String.valueOf(curTime/60);
        String sec = (curTime % 60 >= 10) ? String.valueOf(curTime % 60) : (curTime % 60 > 0) ? "0" + String.valueOf(curTime % 60) : "00";
        answer = min + ":" + sec;
        
        return answer;
    }
}