import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int index = 0;
        for(int[] arr: commands) {
            int[] newArr = new int[arr[1] - arr[0] + 1];
            int newIdx = 0;
            for(int i=arr[0]-1; i<arr[1]; i++) {
                newArr[newIdx++] = array[i];
            }
            Arrays.sort(newArr);
            answer[index++] = newArr[arr[2]-1];
        }
        
        return answer;
    }
}