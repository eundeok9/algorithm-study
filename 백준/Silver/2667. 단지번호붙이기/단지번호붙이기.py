from collections import deque
import sys

input = sys.stdin.readline

def bfs(x, y):
    cnt = 1
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0  # 방문 표시

    while len(queue) != 0:
        # print(queue)
        (x, y) = queue.popleft();

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if nx >= n or nx < 0 or ny < 0 or ny >= n:
                continue

            if graph[nx][ny] == 1:
                cnt += 1
                graph[nx][ny] = 0
                queue.append((nx,ny))

    town.append(cnt)

n = int(input())
graph = []
town = []

# 좌 상 우 하
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]

for _ in range(n):
    graph.append(list(map(int,input().rstrip())))

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            bfs(i, j)

town.sort()
print(len(town))
for i in range(len(town)):
    print(town[i])

