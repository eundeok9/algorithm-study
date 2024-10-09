import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        HashSet<Integer> divSet = new HashSet<>();
        divSet.add(1);
        for(int i=2; i*i <= total; i++) {
            if(total % i ==0) {
                divSet.add(i);
                divSet.add(total/i);
            }
        }
        divSet.add(total);
        
        ArrayList<Integer> divList = new ArrayList<>(divSet);
        Collections.sort(divList);
        
        for(int i=0; i < divList.size() / 2; i++) {
            int h = divList.get(i);
            int w = divList.get(divList.size() - i - 1);
            if((h-2) * (w-2) == yellow) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        
        if(divList.size() % 2 != 0) {
            answer[0] = divList.get(divList.size()/2);
            answer[1] = divList.get(divList.size()/2);
        }
        
        return answer;
    }
}