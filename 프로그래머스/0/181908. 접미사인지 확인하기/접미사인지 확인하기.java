class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        
        if(is_suffix.length() <= my_string.length()) {
            int len = is_suffix.length();
            String suffix = my_string.substring(my_string.length() - len);
            if(suffix.equals(is_suffix)) {
                answer = 1;
            } else {
                answer = 0;
            }
        }

        
        return answer;
    }
}