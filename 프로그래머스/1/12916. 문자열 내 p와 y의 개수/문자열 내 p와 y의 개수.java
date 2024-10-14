class Solution {
    boolean solution(String s) {
        int x = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.toLowerCase(ch) == 'p') {
                x++;
            } else if(Character.toLowerCase(ch) == 'y') {
                x--;
            }
        }
        
        return x == 0;
    }
}