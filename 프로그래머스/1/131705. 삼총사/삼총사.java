class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int[] number) {
        visited = new boolean[number.length];
        backTracking(number, 0, 0, 0);
        return answer;
    }
    
    public static void backTracking(int[] number, int start, int depth, int sum) {
        if(depth == 3) {
            if(sum == 0) {
                answer++;
            }
            return;
        }
        
        for(int i=start; i<number.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTracking(number, i, depth + 1, sum + number[i]);
                visited[i] = false;
            }
        }
    }
}