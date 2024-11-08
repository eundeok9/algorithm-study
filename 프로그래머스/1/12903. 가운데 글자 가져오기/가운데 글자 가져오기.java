class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String[] sarr = s.split("");
        
        if(sarr.length % 2 == 0) {
            answer.append(sarr[sarr.length / 2 - 1]);
            answer.append(sarr[sarr.length / 2]);
        } else {
            return sarr[sarr.length / 2];
        }
        
        return answer.toString();
    }
}