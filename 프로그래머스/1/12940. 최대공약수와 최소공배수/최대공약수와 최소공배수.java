class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = gcd(n, m); // 최대공약수
        answer[1] = n * m / gcd(n, m); // 최소공배수
        
        return answer;
    }
    
    // 최대공약수 구하기: 유클리드 호제법
    public static int gcd(int a, int b) {
        if(a<b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while(b!=0) {
            int r = a%b;
            a = b;
            b = r;
        }
        
        return a;
    }
}