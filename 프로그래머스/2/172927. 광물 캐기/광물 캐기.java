class Solution {
    static int pickCnt = 0;
    static int[] selected;
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        pickCnt = picks[0] + picks[1] + picks[2];
        
        selected = new int[pickCnt];
        
        backTracking(0, picks, minerals);
        
        return answer;
    }
    
    static void backTracking(int depth, int[] picks, String[] minerals) {
        if(depth == pickCnt) {
            // 피로도 구하기
            answer = Math.min(getFatigue(minerals), answer);
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(picks[i] > 0) {
                picks[i] -= 1;
                selected[depth] = i;
                backTracking(depth+1, picks, minerals);
                selected[depth] = 0;
                picks[i] += 1;
            }
        }
    }
    
    static int getFatigue(String[] minerals) {
        int fatigue = 0;
        boolean isFinished = false;
        for(int i=0; i<pickCnt; i++) {
            int pickNum = selected[i];
            for(int j=i*5; j<Math.min(minerals.length, i*5+5); j++) {
                switch(pickNum) {
                    case 0:
                        fatigue += 1;
                        break;
                    case 1:
                        if(minerals[j].equals("diamond")) fatigue += 5;
                        else fatigue+= 1;
                        break;
                    case 2:
                        if(minerals[j].equals("diamond")) fatigue += 25;
                        else if(minerals[j].equals("iron")) fatigue += 5;
                        else fatigue += 1;
                        break;
                }
                
                // if(j == minerals.length - 1) {
                //     isFinished = true;
                //     break;
                // }
            }
            // if(isFinished) break;
        }
        
        return fatigue;
    }
}