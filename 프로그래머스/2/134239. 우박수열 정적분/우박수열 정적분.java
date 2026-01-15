import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Double> areas = new ArrayList<>();
        int n = 0;
        while(true) {
            if(k==1) break;
            
            int nk = (k%2==0) ? k/2 : k*3+1;
            
            double area = (double) (k + nk) / 2;
            
            areas.add(area);
            
            k = nk;
            n++;
        }
        
        for(int i=0; i<ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            if(a>b) {
                answer[i] = -1;
                continue;
            }
            
            double area = 0;
            for(int x=a; x<b; x++) {
                area += areas.get(x);
            }
            
            answer[i] = area;
        }
        
        return answer;
    }
}