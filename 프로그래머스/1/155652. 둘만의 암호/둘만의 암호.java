class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int tmp_index = index;
            while(tmp_index > 0) {
                ch += 1;
                
                if(ch > 'z') {
                    ch -= 26; // z 넘어가면 다시 a로
                }
                
                if(skip.contains(String.valueOf(ch))) {
                    continue;
                } else {
                    tmp_index--;
                }
            }
            
            answer += ch;
        }
        
        return answer;
    }
}