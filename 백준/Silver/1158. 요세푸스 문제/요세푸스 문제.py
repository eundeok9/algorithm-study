from collections import deque
import sys
input = sys.stdin.readline

n, k = list(map(int, input().rstrip().split()))

numbers = deque()
for i in range(n):
    numbers.append(i+1)

answer = []
while numbers:
    for _ in range(k-1):
        numbers.append(numbers.popleft())
    answer.append(numbers.popleft())

print("<", end="")
for i in range(len(answer)-1):
    print(answer[i], end="")
    print(", ", end="")
print(answer[len(answer)-1], end="")
print(">")