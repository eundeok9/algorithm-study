import java.util.*;
class Solution {
    public int solution(String[] strs, String t) {
        int n = t.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 아무것도 사용하지 않았을 때
        
        Set<String> set = new HashSet<>(Arrays.asList(strs));
        
        // dp 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5 && i - j >= 0; j++) { // 길이 1~5의 조각만 확인
                String sub = t.substring(i - j, i); // 현재 부분 문자열
                if (set.contains(sub) && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}