import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
         for (String tree : skill_trees) {
            String filtered = "";
            // skill에 있는 문자만 남기기
            for (char c : tree.toCharArray()) {
                if (skill.indexOf(c) != -1) {
                    filtered += c;
                }
            }
            
            // 순서가 올바른지 확인
            if (skill.startsWith(filtered)) {
                answer++;
            }
        }
        
        return answer;
    }
}