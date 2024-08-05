# 1초, 128mb
import sys
input = sys.stdin.readline

n = int(input())
nums = set(map(int, input().split()))
x = int(input())

ans = 0

for i in nums:
    j = x - i # x = i + j 이므로 j = x - i
    if j in nums:
        ans += 1

print(int(ans//2)) # (12, 1), (1, 12) 같은 경우 2번 count 되므로 /2