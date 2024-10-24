class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        
        String[] nums = Integer.toString(x).split("");
        
        for(String num: nums) {
            sum += Integer.parseInt(num);
        }

        return x % sum == 0;
    }
}