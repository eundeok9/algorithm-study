# 1초, 512mb
import sys
input = sys.stdin.readline

tc = int(input())

for _ in range(tc):
    n = int(input())
    
    dp = [0 for _ in range(12)]
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for i in range(4, n+1):
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
        
    print(dp[n])