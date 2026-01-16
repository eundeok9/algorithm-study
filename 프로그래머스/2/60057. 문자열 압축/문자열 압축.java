class Solution {
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();
        
        if(s.length()==1) return 1;
        
        for(int r=1; r<=len/2; r++) {
        	String pattern = s.substring(0,r);
        	int cnt = 1;
        	String reStr = "";
        	for(int i=r; i<=s.length()-r; i+=r){
        		if(pattern.equals(s.substring(i,i+r))){
    				cnt++;
    			} else {
    				if(cnt > 1) {
    					reStr += cnt + "";
    				}
   				    reStr += pattern;
                    
                    // 다음 반복되는 문자 찾기
    				pattern = s.substring(i,i+r);
    				cnt = 1;
    			}
        	}
        	
        	if(cnt>1) {
    			reStr += "" + cnt;
    		}
    		reStr += pattern;
    		
    		int div = s.length() % r; // r 단위로 자르고 남은 문자 개수
    		answer = Math.min(answer, reStr.length()+div);
        }
        return answer;
    }
}