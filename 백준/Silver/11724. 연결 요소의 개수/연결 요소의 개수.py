from collections import deque

import sys
input = sys.stdin.readline


def bfs(start):
    queue = deque()
    queue.append(start)

    while queue:
        cur = queue.popleft()

        for nxt in graph[cur]:
            if not visited[nxt]:
                queue.append(nxt)
                visited[nxt] = True



n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False for _ in range(n+1)]

cnt = 0
for i in range(1, n+1):
    if not visited[i]:
        bfs(i)
        cnt += 1
print(cnt)