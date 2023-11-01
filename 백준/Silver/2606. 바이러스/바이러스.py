from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    cnt = 0
    queue = deque()
    queue.append(0)
    visited[0] = True

    while queue:
        i = queue.popleft()

        for j in graph[i]:
            if visited[j]:
                continue
            visited[j] = True
            queue.append(j)
            cnt += 1
    return cnt

n = int(input()) # 컴퓨터 수
m = int(input()) # 연결되어있는 컴퓨터 쌍의 수

graph = [[] for _ in range(n)]
visited = [False for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    graph[a].append(b)
    graph[b].append(a)

print(bfs())