class Solution {
    public String solution(String new_id) {
        // 1단계: 소문자로 변경
        new_id = new_id.toLowerCase();
        
        // 2단계: 허용하지 않는 문자 제거
        StringBuilder id = new StringBuilder();
        for(int i=0; i<new_id.length(); i++) {
            char ch = new_id.charAt(i);
            
            if(Character.isDigit(ch) || Character.isAlphabetic(ch) || 
              ch == '-' || ch == '_' || ch == '.') {
                id.append(String.valueOf(ch));
            }
        }
        
        String answer = id.toString();
        
        // 3단계: 연속된 점 제거
        while (answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }
        
        // 4단계: 문자 맨앞, 맨뒤에 위치하는 점 제거
        if(!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length()-1);
        }
        
        // 5단계: 빈문자열일 경우
        if(answer.isEmpty()) {
            answer = "a";
        }
        
        // 6단계: 15글자 초과할 경우
        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        // 7단계: 3글자 미만일 경우
        while(answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }
        
        return answer;
    }
}