import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (a, b) -> {
            // n번째 index 문자를 기준으로 비교
            int compare = Character.compare(a.charAt(n), b.charAt(n));
            
            // 같은 문자일 경우 사전 순으로 정렬
            if(compare == 0) {
                return a.compareTo(b);
            }
            
            return compare;
        });
        
        return strings;
    }
}