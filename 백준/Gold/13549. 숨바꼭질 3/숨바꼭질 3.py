# 2초, 512mb
import sys
input = sys.stdin.readline
from collections import deque

n, k = map(int, input().split())
visited = [0 for _ in range(100001)]

queue = deque()
queue.append(n)
visited[n] = 1

while queue:
    a = queue.popleft()
    
    if a == k:
        break
    
    for i in (a*2, a-1, a+1):
        if 0 <= i <= 100000 and visited[i] == 0:
            if i != a*2:
                visited[i] = visited[a] + 1
                queue.append(i)
            else:
                visited[i] = visited[a]
                queue.appendleft(i)

print(visited[k]-1)