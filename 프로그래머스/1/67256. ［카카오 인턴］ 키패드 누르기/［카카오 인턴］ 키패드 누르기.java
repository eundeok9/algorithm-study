class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int[][] location = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
        int[] curLeft = {3,0};
        int[] curRight = {3,2};
        
        for(int num: numbers) {
            if(num == 1 || num == 4 || num == 7) {
                answer.append("L");
                curLeft = location[num];
            } else if(num == 3 || num == 6 || num == 9) {
                answer.append("R");
                curRight = location[num];
            } else {
                int leftDiff = Math.abs(curLeft[0] - location[num][0]) + Math.abs(curLeft[1] - location[num][1]);
                int rightDiff = Math.abs(curRight[0] - location[num][0]) + Math.abs(curRight[1] - location[num][1]);
                
                if(leftDiff < rightDiff) {
                    answer.append("L");
                    curLeft = location[num];
                } else if (leftDiff > rightDiff) {
                    answer.append("R");
                    curRight = location[num];
                } else {
                    if(hand.equals("right")) {
                        answer.append("R");
                        curRight = location[num];
                    } else {
                        answer.append("L");
                        curLeft = location[num];
                    }
                }
                
            }
        }
        
        return answer.toString();
    }
}