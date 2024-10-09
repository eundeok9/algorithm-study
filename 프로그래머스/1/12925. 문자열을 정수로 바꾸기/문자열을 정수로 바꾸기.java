class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.charAt(0) == '-') {
            String newS = "";
            for(int i=1; i<s.length(); i++) {
                newS += s.charAt(i);
            }
            answer = -1 * Integer.parseInt(newS);
        } else {
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}