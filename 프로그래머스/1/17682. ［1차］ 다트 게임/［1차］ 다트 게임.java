class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] nums = new int[3];
        int index = 0;
        String numStr = "";
        int n = 0;
        
        for(int i=0; i<dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            if(0<=(int)ch - '0' && (int)ch - '0' <=9) {
                numStr += String.valueOf(ch);
            } else if(ch == 'S') {
                n = Integer.parseInt(numStr);
                nums[index++] = (int)Math.pow(n,1);
                numStr = "";
            } else if(ch == 'D') {
                n = Integer.parseInt(numStr);
                nums[index++] = (int)Math.pow(n,2);
                numStr = "";
            } else if(ch == 'T') {
                n = Integer.parseInt(numStr);
                nums[index++] = (int)Math.pow(n,3);
                numStr = "";
            } else if(ch == '#') {
                nums[index-1] = nums[index-1] * -1;
            } else if(ch == '*') {
                nums[index-1] = nums[index-1] * 2;
                if(index > 1) {
                    nums[index-2] = nums[index-2] * 2;
                }
            }
        }
        
        for(int num : nums) {
            answer += num;
        }
        
        return answer;
    }
}