# 2초, 512mb
import sys
input = sys.stdin.readline
from collections import deque

n, k = map(int, input().split())

numbers = deque([i for i in range(1, n+1)])
ans = []

while numbers:
    for _ in range(k-1):
        numbers.append(numbers.popleft())
    ans.append(str(numbers.popleft()))
    
print("<", ", ".join(ans), ">", sep="")
