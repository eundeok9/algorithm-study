import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, HashSet<String>> reportedInfo = new HashMap<>(); // 각 유저를 신고한 유저
        HashMap<String, Integer> reporterIdx = new HashMap<>(); // 각 유저의 id_list에서 index
        
        for(int i=0; i<id_list.length; i++) {
            String name = id_list[i];
            reportedInfo.put(name, new HashSet<>());
            reporterIdx.put(name, i);
        }
        
        for(String r: report) {
            String[] sarr = r.split(" ");
            String reporter = sarr[0];
            String reported = sarr[1];
            reportedInfo.get(reported).add(reporter);
        }
        
        for(int i=0; i<id_list.length; i++) {
            HashSet<String> send = reportedInfo.get(id_list[i]);
            if(send.size() >= k) {
                for(String name: send) {
                    answer[reporterIdx.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}