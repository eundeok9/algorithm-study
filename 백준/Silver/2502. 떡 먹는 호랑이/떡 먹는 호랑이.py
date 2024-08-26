# 1초, 128mb
import sys
input = sys.stdin.readline

d, k = map(int, input().split())

dp = [0 for _ in range(d)]
dp[0], dp[1] = 1, 1

while True:
    for i in range(2, d):
        dp[i] = dp[i-2] + dp[i-1]
        
    if dp[d-1] == k:
        print(dp[0])
        print(dp[1])
        break
    elif dp[-1] > k:
        dp[0] += 1
        dp[1] = dp[0]
    else:
        dp[1] += 1
