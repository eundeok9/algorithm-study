class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        gcdA = check(gcdA, arrayB) ? gcdA : 0;
        gcdB = check(gcdB, arrayA) ? gcdB : 0;
        
        return Math.max(gcdA, gcdB);
    }
    
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    static boolean check(int a, int[] arr) {
        for (int n : arr) {
            if (n % a == 0) return false;  // 나눌 수 있는 수가 있으면 false
        }
        return true; 
    }
}