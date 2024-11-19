class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        
        for(int i=0; i<X.length(); i++) {
            int num = X.charAt(i) - '0';
            count1[num]++;
        }
        
        
        for(int i=0; i<Y.length(); i++) {
            int num = (int)Y.charAt(i) - '0';
            count2[num]++;
        }

        
        for(int i=9; i>=0; i--) {
            for(int j=0; j<Math.min(count1[i], count2[i]); j++) {
                answer.append(i);
            }
        }
        
        if(answer.toString().equals("")) {
            return "-1";
        } else if (answer.toString().charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}