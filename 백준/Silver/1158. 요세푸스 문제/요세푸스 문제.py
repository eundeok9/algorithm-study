 # 2초, 256mb
from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

numbers = deque()
for i in range(n):
    numbers.append(i+1)

ans = []
while numbers:
    for _ in range(k-1):
        numbers.append(numbers.popleft())
    ans.append(numbers.popleft())


print("<", end="")
for i in range(len(ans)-1):
    print(ans[i], end="")
    print(", ", end="")
print(ans[len(ans)-1], end="")
print(">")