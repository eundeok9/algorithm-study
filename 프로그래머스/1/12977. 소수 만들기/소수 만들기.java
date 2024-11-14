class Solution {
    public static int answer = 0;
    public static boolean[] visited;
    public int solution(int[] nums) {
        visited = new boolean[nums.length];
        
        backTracking(nums, 0, 0, 0);
        
        return answer;
    }
    
    public void backTracking(int[] nums, int start, int depth, int sum) {
        if(depth == 3) {
            if(isPrime(sum)) {
                answer++;
            }
            return;
        }
        
        for(int i=start; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTracking(nums, i, depth+1, sum+nums[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}