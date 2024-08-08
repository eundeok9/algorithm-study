# 1초, 128mb
import sys
input = sys.stdin.readline

n = int(input())
heights = []

for _ in range(n):
    heights.append(int(input()))

stack = []
ans = 0

for i in heights:
    while stack and stack[-1] <= i:
        stack.pop()
    stack.append(i)
    
    ans += len(stack) -1

print(ans)