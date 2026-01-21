class Solution {
    public long solution(int w, int h) {
        return (long) w*h - (w+h - gcd(w,h));
    }
    
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}