import java.util.*;

class Solution {
    static boolean[] isVisited = new boolean[7];
    static HashSet<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        backTracking(numbers, "", 0);
        
        for(int num: set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void backTracking(String numbers, String s, int depth) {
        if(depth == numbers.length()) {
            return;
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                backTracking(numbers, s+numbers.charAt(i), depth+1);
                isVisited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for(int i=2; i*i<=num; i++) {
            if(num%i==0) {
                return false;
            }
        }
        
        return true;
    }
}