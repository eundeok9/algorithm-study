
def dfs(i):
    visited[i] = 1

    for node in graph[i]:
        if visited[node]:
            continue
        dfs(node)

t = int(input())

for tc in range(1, t+1):
    n, m = list(map(int, input().split()))

    graph = [[] for _ in range(n)]

    for _ in range(m):
        a, b = list(map(int, input().split()))
        a -= 1 # 0부터 시작이라서 1씩 빼줌
        b -= 1
        graph[a].append(b)
        graph[b].append(a)

    visited = [0 for _ in range(n)]
    cnt = 0 # 무리 개수

    for i in range(n):
        if visited[i]:
            continue
        dfs(i)
        cnt += 1

    print("#{} {}".format(tc, cnt))