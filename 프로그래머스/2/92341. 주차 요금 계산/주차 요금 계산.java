import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> map1 = new HashMap<>(); // 차량 출차 내역
        HashMap<String, Integer> map2 = new HashMap<>(); // 차량 주차 누적 시간
        
        for(String record: records) {
            String[] sarr = record.split(" ");
            if(sarr[2].equals("IN")) { // 입차
                map1.put(sarr[1], sarr[0]);
            } else {
                String in = map1.get(sarr[1]);
                int time = calculate(in.split(":"), sarr[0].split(":"));
                map2.put(sarr[1], map2.getOrDefault(sarr[1], 0) + time);
                map1.remove(sarr[1]);
            }
        }
        if(map1.size() != 0) {
            for(String number: map1.keySet()) {
                String in = map1.get(number);
                int time = calculate(in.split(":"), new String[] {"23", "59"});
                map2.put(number, map2.getOrDefault(number, 0) + time);
            }
        }
        ArrayList<String> list = new ArrayList<>(map2.keySet());
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = calculateFee(map2.get(list.get(i)), fees);
        }
        
        return answer;
    }
    
    public static int calculate(String[] in, String[] out) {
        // 입차 시간과 출차 시간 차이를 분 단위로 계산
        int inTime = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
        int outTime = Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1]);
        
        return outTime - inTime;
    }
    
    public static int calculateFee(int time, int[] fees) {
        if (time <= fees[0]) {
            return fees[1]; // 기본 요금
        } else {
            int extraTime = time - fees[0];
            int extraFee = (int) Math.ceil((double) extraTime / fees[2]) * fees[3];
            return fees[1] + extraFee;
        }
    }
}