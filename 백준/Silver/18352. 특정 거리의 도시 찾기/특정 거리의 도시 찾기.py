# 2초, 256mb
import sys
input = sys.stdin.readline
from collections import deque

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]
distance = [0 for _ in range(n+1)]
visited = [0 for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

def bfs(start):
    result = []
    queue = deque([start])
    visited[start] = 1
    distance[start] = 0
    
    while queue:
        a = queue.popleft()
        for i in graph[a]:
            if not visited[i]:
                visited[i] = 1
                queue.append(i)
                distance[i] = distance[a] + 1
                if distance[i] == k:
                    result.append(i)
    
    if len(result) == 0:
        print(-1)
    else:
        result.sort()
        for num in result:
            print(num)
    
bfs(x)