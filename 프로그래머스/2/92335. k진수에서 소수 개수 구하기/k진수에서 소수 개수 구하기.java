class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] sarr = Integer.toString(n, k).split("0+");
        
        for(String s: sarr) {
            if(isPrime(Long.parseLong(s))) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(long num) {
        if(num < 2) return false;
        for(long i=2; i*i<=num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}