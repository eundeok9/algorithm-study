import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        
        int n = elements.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            set.add(elements[i]); // 1개 선택 시 나올 수 있는 합
            sum += elements[i];
        }
        set.add(sum); // n개 선택 시 나올 수 있는 합
        
        int[] arr = new int[n*2 - 2]; // 누적합 저장
        arr[0] = elements[0];
        for(int i=1; i<n; i++) {
            arr[i] = arr[i-1] + elements[i];   
        }
        for(int i=0; i<n-2; i++) {
            arr[n+i] = arr[n+i-1] + elements[i];
        }
        
        for(int cnt=2; cnt<n; cnt++) {// 2~n-1개 선택 시 나올 수 있는 합
            set.add(arr[cnt-1]);
            for(int i=cnt; i<cnt+n-1; i++) {
                set.add(arr[i]-arr[i-cnt]);
            }
        }
        
        return set.size();
    }
}