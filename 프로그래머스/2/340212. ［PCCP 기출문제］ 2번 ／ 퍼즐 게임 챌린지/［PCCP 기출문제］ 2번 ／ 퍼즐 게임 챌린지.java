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
                int diff = diffs[i];
                int time_cur = times[i];
                
                if (diff<=mid) {
                    time += time_cur;
                } else {
                    int time_prev = i == 0 ? 0 : times[i-1];
                    time += (diff - mid) * (time_cur + time_prev) + time_cur;
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