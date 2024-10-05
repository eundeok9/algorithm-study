class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        int len = my_string.length();
        
        for(int i = 0; i < len; i++) {
            char ch = my_string.charAt(i);
            if(Character.isDigit(ch)){
                answer += (int)(ch - '0');
            }
        }
        
        return answer;
    }
}