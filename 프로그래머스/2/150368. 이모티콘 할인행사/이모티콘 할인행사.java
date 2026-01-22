import java.util.*;
class Solution {
    static int[] salePercents;
    static int n, m;
    static List<Result> resultList;
    static class Result implements Comparable<Result> {
        int count, amount;
        Result(int count, int amount) {
            this.count = count;
            this.amount = amount;
        }
        public int compareTo(Result o) {
            if(this.count == o.count) {
                return o.amount - this.amount;
            }
            return o.count - this.count;
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        n = users.length;
        m = emoticons.length;
        
        salePercents = new int[m];
        resultList = new ArrayList<>();
        dfs(0, users, emoticons);
        
        Collections.sort(resultList);
        answer[0] = resultList.get(0).count;
        answer[1] = resultList.get(0).amount;
        
        return answer;
    }
    

    static void dfs(int depth, int[][] users, int[] emoticons) {
        if(depth==emoticons.length) {
            calculate(users, emoticons);
            return;
        }
        
        for(int i=10; i<=40; i+=10) {
            salePercents[depth] = i;
            dfs(depth+1, users, emoticons);
        }
    }
    
    static void calculate(int[][] users, int[] emoticons) {
        int[] tmpEmoticons = new int[m];
        for(int i=0; i<m; i++) {
            tmpEmoticons[i] = emoticons[i] - (emoticons[i] * salePercents[i] / 100);
        }
        
        int count = 0;
        int amount = 0;
        for(int i=0; i<n; i++) {
            int wantedPercent = users[i][0];
            int wantedAmount = users[i][1];
            
            int sum = 0;
            for(int j=0; j<m; j++) {
                if(salePercents[j] >= wantedPercent) {
                    sum += tmpEmoticons[j];
                }
            }
            
            if(sum >= wantedAmount) {
                count++;
            } else {
                amount += sum;
            }
        }
        
        resultList.add(new Result(count, amount));
    }
}