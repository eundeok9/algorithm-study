# 1260번. DFS와 BFS
# 문제) 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램 작성
# 입력) 정점의 개수: N, 간선의 개수 M, 탐색을 시작할 번호 V
# 출력) 첫째 줄에 DFS 수행한 결과, 다음 줄에 BFS 수행한 결과
# 조건) 시간 제한: 2초, 메모리 제한: 128MB

from collections import deque
def dfs(start):
    visited1[start] = True
    print(start, end=' ')
    for i in graph[start]:
        if not visited1[i]:
            dfs(i)


def bfs(start):
    queue = deque([start])
    visited2[start] = True

    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited2[i]:
                queue.append(i)
                visited2[i] = True


n, m, v = map(int,input().split())

graph = [[] for _ in range(n+1)]

visited1 = [False] * (n+1) # dfs를 위한 방문처리
visited2 = [False] * (n+1) # bfs를 위한 방문처리

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

dfs(v)
print()
bfs(v)



