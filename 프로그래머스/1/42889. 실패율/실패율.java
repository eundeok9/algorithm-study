import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] failCnt = new int[N+2];
        int[] totalCnt = new int[N+1];
        
        for(int stage: stages) {
            failCnt[stage] += 1;
        }
        
        totalCnt[N] = failCnt[N+1] + failCnt[N];
        for(int i=N-1; i>0; i--) {
            totalCnt[i] = failCnt[i] + totalCnt[i+1];
        }
        
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i=1; i<totalCnt.length; i++) {
            if(totalCnt[i] == 0 || failCnt[i] == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double)failCnt[i] / totalCnt[i]);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}