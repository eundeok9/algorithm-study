import java.util.*;
class Solution {
    static class Booking implements Comparable<Booking> {
        String startTime;
        String endTime;
        int startTimeToInt;
        int endTimeToInt;
        
        Booking(String s, String e) {
            this.startTime = s;
            this.endTime = e;
            this.startTimeToInt = convertTimeToInt(s);
            this.endTimeToInt = convertTimeToInt(e);
        }
        
        private int convertTimeToInt(String s) {
            String[] sarr = s.split(":");
            
            return Integer.parseInt(sarr[0]) * 60 + Integer.parseInt(sarr[1]);
        }
        
        // 시작시간 오름차순으로 정렬
        public int compareTo(Booking o) {
            return this.startTimeToInt - o.startTimeToInt;
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Booking[] bookArr = new Booking[book_time.length];
        
        for(int i=0; i<book_time.length; i++) {
            bookArr[i] = new Booking(book_time[i][0], book_time[i][1]);
        }
        
        Arrays.sort(bookArr);
        
        List<Integer> roomList = new ArrayList<>();
        for(Booking b: bookArr) {
            int startTime = b.startTimeToInt;
            int endTime = b.endTimeToInt;
            
            boolean flag = false;
            for(int i=0; i<roomList.size(); i++) {
                if(roomList.get(i) <= startTime) {
                    roomList.set(i,endTime + 10);
                    flag = true;
                    break;
                }
            }
            
            if(!flag) {
                roomList.add(endTime+10);
            }
        }
        
        return roomList.size();
    }
}