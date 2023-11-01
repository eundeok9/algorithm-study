from collections import deque
import sys
input = sys.stdin.readline

def dfs(v):
    visited[v] = True
    print(v, end=" ")

    graph[v].sort()
    for nxt in graph[v]:
        if not visited[nxt]:
            dfs(nxt)

def bfs(v):
    queue = deque()
    queue.append(v)
    visited[v] = True # 방문 처리 유의하기~

    while queue:
        now = queue.popleft()
        print(now, end=" ")
        graph[now].sort()
        for nxt in graph[now]:
            if not visited[nxt]:
                visited[nxt] = True # 방문 처리 유의하기~
                queue.append(nxt)


# n: 정점의 개수
# m: 간선의 개수
# v: 시작 정점
n, m, v = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False for _ in range(n+1)]
dfs(v)
print()
visited = [False for _ in range(n+1)]
bfs(v)