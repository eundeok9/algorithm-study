class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 0;
        for(int i=0; i<diffs.length; i++) {
            end = Math.max(end, diffs[i]);
        }
        
        while(start < end) {
            int mid = (start + end) / 2;
            
            long time = 0;
            for(int i=0; i<diffs.length; i++) {
                if(mid >= diffs[i]) {
                    time += times[i];
                } else {
                    int time_prev = i == 0 ? 0 : times[i-1];
                    time += (diffs[i] - mid) * (time_prev + times[i]) + times[i];
                }
            }
            
            if(time <= limit) {
                end = mid;
            } else {
                start = mid + 1;
            }
            
        }
        
        return end;
    }
}