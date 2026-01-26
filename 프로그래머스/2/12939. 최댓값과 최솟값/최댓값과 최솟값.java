import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            if(max < num) {
                max = num;
            }
            if(min > num) {
                min = num;
            }
        }
        
        String answer = min + " " + max;
        
        return answer;
    }
}