import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
graph = [[] for i in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

queue = deque()
queue.append(1)

parent = [0] * (n+1)

def bfs():
    while queue:
        now = queue.popleft()
        for nxt in graph[now]:
            if parent[nxt] == 0:
                parent[nxt] = now
                queue.append(nxt)

bfs()
res = parent[2:]

for i in res:
    print(i)