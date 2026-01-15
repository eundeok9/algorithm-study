class Solution {
    static int[][] answer;
    static int index = 0;
    public int[][] solution(int n) {
        int count = (1 << n) - 1;
        answer = new int[count][2];
        
        hanoi(n, 1, 3, 2);
        
        return answer;
    }
    
    static void hanoi(int n, int start, int destination, int via) {
        if(n<=1) {
            answer[index][0] = start;
            answer[index++][1] = destination;
            
            return;
        }
        
        hanoi(n-1, start, via, destination);
        
        answer[index][0] = start;
        answer[index++][1] = destination;
        
        hanoi(n-1, via, destination, start);
        
        return;
    }
}