class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        int len = my_string.length();
        
        for(int i=0; i<len; i++) {
            char ch = my_string.charAt(i);
            if(Character.isUpperCase(ch)) {
                answer += Character.toLowerCase(ch);
            }
            else {
                answer += Character.toUpperCase(ch);
            }
        }
        
        return answer;
    }
}