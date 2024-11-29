class Solution {
    public int solution(int a, int b) {
        int oper = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        
        return oper >= 2*a*b ? oper : 2*a*b;
    }
}