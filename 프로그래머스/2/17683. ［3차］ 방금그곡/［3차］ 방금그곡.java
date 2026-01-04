import java.util.*;
class Solution {
    static class Music implements Comparable<Music> {
        int time; String subject;
        Music(int time, String subject) {
            this.time = time;
            this.subject = subject;
        }
        
        // 재생된 시간이 긴 순서 (내림차순)
        public int compareTo(Music o) {
            return o.time - this.time;
        }
    }
    public String solution(String m, String[] musicinfos) {
        List<Music> answerList = new ArrayList<>();
        
        for(String musicInfo: musicinfos) {
            // sp[0]: 시작 시간
            // sp[1]: 끝난 시간
            // sp[2]: 제목
            // sp[3]: 악보 정보
            String[] sp = musicInfo.split(",");
            int startTime = toMin(sp[0]);
            int endTime = toMin(sp[1]);
            int playTime = endTime - startTime;
            
            List<String> melodyList = new ArrayList<>();
            int index = 0;
            for(int i=0; i<playTime; i++) {
                String s = "";
                if(index == sp[3].length()) index = 0;
                s += sp[3].charAt(index++);
                if(index < sp[3].length() && sp[3].charAt(index) == '#') {
                    s += sp[3].charAt(index++);
                }
                melodyList.add(s);
            }
            
            List<String> mList = new ArrayList<>();
            index = 0;
            for(int i=0; i<m.length(); i++) {
                if(index == m.length()) break;
                String s = "";
                s += m.charAt(index++);
                if(index < m.length() && m.charAt(index) == '#') {
                    s += m.charAt(index++);
                }
                mList.add(s);
            }
            
            boolean matched = false;

            for (int i = 0; i <= melodyList.size() - mList.size(); i++) {
                boolean ok = true;
                for (int j = 0; j < mList.size(); j++) {
                    if (!melodyList.get(i + j).equals(mList.get(j))) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    matched = true;
                    break;
                }
            }
            
            if(matched) {
                answerList.add(new Music(playTime, sp[2]));
            }
        }
        
        if (answerList.isEmpty()) return "(None)";
        
        Collections.sort(answerList);
        return answerList.get(0).subject;
    }
    
    static int toMin(String s) {
        return Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
    }
}