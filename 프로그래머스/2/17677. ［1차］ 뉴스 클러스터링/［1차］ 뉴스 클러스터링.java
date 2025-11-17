import java.util.*;

class Solution {
    static final int NUMBER = 65536;
    public int solution(String str1, String str2) {
        int answer = 0;
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++) {
            char c1 = str1.toLowerCase().charAt(i);
            char c2 = str1.toLowerCase().charAt(i+1);
            
            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c1).append(c2);
                map1.put(sb.toString(), map1.getOrDefault(sb.toString(), 0) + 1);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            char c1 = str2.toLowerCase().charAt(i);
            char c2 = str2.toLowerCase().charAt(i+1);
            
            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c1).append(c2);
                map2.put(sb.toString(), map2.getOrDefault(sb.toString(), 0) + 1);
            }
        }
        
        int commonCount = 0;
        int unionCount = 0;
        for(String s: map1.keySet()) {
            unionCount += map1.get(s);
            if(map2.containsKey(s)) {
                commonCount += Math.min(map1.get(s), map2.get(s));
            }
        }
        
        for(String s: map2.keySet()) {
            unionCount += map2.get(s);
        }
        
        unionCount -= commonCount;
        
        if(unionCount == 0) return NUMBER;
        
        System.out.println(commonCount + " " + unionCount);
        System.out.println((double) commonCount / unionCount);
        return commonCount * NUMBER / unionCount;
    }
}