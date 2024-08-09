# 1초, 512mb
import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
nge = [-1 for _ in range(n)]
stack = [0] # 인덱스 저장할 스택

for i in range(1, n):
    while stack and arr[stack[-1]] < arr[i]:
        nge[stack[-1]] = arr[i]
        stack.pop()
    stack.append(i)
    
print(*nge)