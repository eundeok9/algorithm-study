# 1.5초, 128mb
import sys
input = sys.stdin.readline

n = int(input())
# top = input().split()
top = list(map(int, input().split())) # 정수로 받아야함
stack = []
ans = [0 for _ in range(n)]

for i in range(n):
    while stack:
        if stack[-1][1] > top[i]:
            ans[i] = stack[-1][0] + 1
            break
        else:
            stack.pop()
    stack.append((i, top[i]))

print(*ans)