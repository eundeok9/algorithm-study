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
        
        PriorityQueue<Integer> roomPQ = new PriorityQueue<>();

        for (Booking b : bookArr) {
            int startTime = b.startTimeToInt;
            int endTime = b.endTimeToInt;

            if (!roomPQ.isEmpty() && roomPQ.peek() <= startTime) {
                roomPQ.poll();
            }

            roomPQ.offer(endTime + 10);
        }

        return roomPQ.size();
    }
}