class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            answer[i] = String.valueOf(Integer.toBinaryString(arr1[i] | arr2[i]));
            
            // 2진수로 변환한 값이 n자리수가 아닐 때 앞에 부족한 자리수만큼 0을 채워줌
            if(answer[i].length() < n) {
                String str = "";
                for(int j=0; j<n-answer[i].length(); j++) {
                    str += "0";
                }
                answer[i] = str + answer[i];
            }
            
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }
        
        return answer;
    }
}