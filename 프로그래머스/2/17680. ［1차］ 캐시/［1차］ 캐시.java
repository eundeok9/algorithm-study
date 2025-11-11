import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(int i=0; i<cities.length; i++) {
            String cityName = cities[i].toLowerCase();
            if(cache.contains(cityName)) {
                answer += 1;
                cache.remove(cityName);
                cache.offer(cityName);
            } else {
                answer += 5;
                if(cacheSize == cache.size()) {
                    cache.poll();
                    cache.offer(cityName);
                } else {
                    cache.offer(cityName);
                }
            }
        }
        
        return answer;
    }
}