import sys
input = sys.stdin.readline

def dfs(r):
    global cnt
    visited[r] = cnt
    graph[r].sort()

    for x in graph[r]:
        if visited[x] == 0:
            cnt += 1
            dfs(x)

sys.setrecursionlimit(10**7)
n, m, r = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

cnt = 1
visited = [0 for _ in range(n+1)]
dfs(r)

for _ in range(1,n+1):
    print(visited[_])