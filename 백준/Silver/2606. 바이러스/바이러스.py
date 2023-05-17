def dfs(v):
    visited[v] = True

    answer.append(v)

    for i in computers[v]:
        if not visited[i]:
            dfs(i)

answer = []
n = int(input()) # 컴퓨터 수
m = int(input()) # 연결된 컴퓨터 쌍의 수

computers = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    a, b = list(map(int, input().split()))
    computers[a].append(b)
    computers[b].append(a)

dfs(1)
print(len(answer)-1)