class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        if(arr.length == 1) {
            return arr[0];
        }
        
        int g = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / g;
        
        for(int i=2; i<arr.length; i++) {
            g = gcd(arr[i], answer);
            answer = (answer * arr[i]) / g;
        }
        
        return answer;
    }
    
    static int gcd(int a, int b) {
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