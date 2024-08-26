# 1초, 256mb
import sys
input = sys.stdin.readline

n = int(input())

if n == 1:
    print(1)
    exit()

dp = [0 for _ in range(n+1)]

dp[1] = 1
dp[2] = 3

for i in range(3, n+1):
    dp[i] = dp[i-2] * 2 + dp[i-1]

print(dp[n] % 10007)