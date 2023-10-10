# 창용 마을 무리의 개수

t = int(input())

def dfs(cur):
    visited[cur] = 1

    for neighbor in graph[cur]:
        if visited[neighbor] == 1:
            continue
        else:
            dfs(neighbor)


for tc in range(1, t+1):

    n, m = list(map(int, input().split()))

    graph = [[] for _ in range(n)]

    for _ in range(m):
        a, b = list(map(int ,input().split()))
        a -= 1
        b -= 1
        graph[a].append(b)
        graph[b].append(a)


    visited = [0 for _ in range(n)]

    cnt = 0
    for i in range(n):
        if visited[i] == 0:
            dfs(i)
            cnt += 1

    print("#{} {}".format(tc, cnt))