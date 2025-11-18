class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        StringBuilder s = new StringBuilder();
        int number = 0;
        while(s.length() < m * t) {
            s.append(Integer.toString(number++, n));
        }
        
        // System.out.println(s);
        
        for(int i=0; i<s.length(); i++) {
            if(i%m+1==p && answer.length() < t) {
                if(Character.isAlphabetic(s.charAt(i))) {
                    answer += Character.toUpperCase(s.charAt(i));
                } else {
                    answer += s.charAt(i);
                }
            }
        }
        
        
        return answer;
    }
}