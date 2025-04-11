import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;    
        
        // 누적합 구하기
        int[] arr = new int[2*n+1];
        for(int i=0; i<2*n; i++) {
            arr[i+1] = arr[i] + elements[i%n];
        }
        
        // 1~n개 선택 시 나올 수 있는 합
        for(int i=0; i<n; i++) {
            for(int L=1; L<=n; L++) {
                set.add(arr[i+L] - arr[i]);
            }
        }
        
        return set.size();
    }
}