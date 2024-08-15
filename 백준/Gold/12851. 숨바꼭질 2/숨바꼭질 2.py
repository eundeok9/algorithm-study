# 2초, 512mb
import sys
input = sys.stdin.readline
from collections import deque

n, k = map(int, input().split())

if n == k:
    print(0)
    print(1)
    sys.exit()

queue = deque()
queue.append(n)

visited = [0 for _ in range(100001)]
cnt = 0

while queue:
    cur = queue.popleft()
    
    if cur == k:
        cnt += 1
        continue
    
    for i in (cur-1, cur+1, cur*2):
        if 0 <= i <= 100000 and (visited[i] == 0 or visited[i] >= visited[cur] + 1):
            visited[i] = visited[cur] + 1
            queue.append(i)

print(visited[k])
print(cnt)