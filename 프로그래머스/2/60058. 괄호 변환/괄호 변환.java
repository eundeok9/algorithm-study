import java.util.*;
class Solution {
    public String solution(String p) {
        if(check(p)) return p;
        else return convert(p);
    }
    
    static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if(c=='(') stack.add(c);
            else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        
        if(!stack.isEmpty()) return false;
        return true;
    }
    
    static String convert(String s) {
        if(s.length() == 0) return s;
        
        String u = "";
        String v = "";
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(c=='(') cnt1++;
            else cnt2++;
            
            // 균형잡힌 문자열일 때 u, v 분리
            if(((cnt1>0) && (cnt2>0)) && (cnt1==cnt2)) {
                u = s.substring(0, i+1);
                if(i<s.length()-1) {
                    v = s.substring(i+1, s.length());
                }
                break;
            }
        }
        
        if(check(u)) return u + convert(v);
        else {
            String tmp = "(" + convert(v) + ")";
            u = u.substring(1, u.length()-1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            tmp = tmp + u;
            return tmp;
        }
    }
}