class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        for(int num: queue1) sum1 += num;
        for(int num: queue2) sum2 += num;
        
        long total = sum1 + sum2;
        if(total%2 != 0) return -1;
        long target = total / 2;
        
        int[] arr = new int[n*2];
        for(int i=0; i<n; i++) arr[i] = queue1[i];
        for(int i=0; i<n; i++) arr[n+i] = queue2[i];
        
        int left = 0;
        int right = n;
        long cur = sum1;
        int count = 0;
        int limit = n * 3; // 언제까지 시행할건지 제한 값
        
        while(count <= limit) {
            if(cur==target) return count;
            if(cur > target) {
                if(left >= 2 * n) return -1;
                cur -= arr[left];
                left++;
            } else {
                if(right >= 2 * n) return -1;
                cur += arr[right];
                right++;
            }
            count++;
        }
        
        return -1;
    }
}