class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        String[] sarr = t.split("");
        
        for(int i=0; i<sarr.length - p.length() + 1; i++) {
            StringBuilder str = new StringBuilder();
            for(int j=i; j<i+p.length(); j++) {
                str.append(sarr[j]);
            }
            if(Long.parseLong(str.toString()) <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}