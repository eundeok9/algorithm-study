# 백준 4485. 녹색 옷 입은 애가 젤다지?
# 시간 제한 1초 / 메모리 제한 256MB
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    global dist
    queue = deque()
    queue.append((0, 0))
    dist[0][0] = graph[0][0]

    while queue:
        x, y = queue.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if not(0 <= nx < n and 0 <= ny < n):
                continue

            cost = graph[nx][ny]

            if dist[nx][ny] > dist[x][y] + cost:
                dist[nx][ny] = dist[x][y] + cost
                queue.append((nx, ny))

index = 1
while True:
    n = int(input())

    if n == 0:
        break

    graph = [list(map(int, input().split())) for _ in range(n)]

    dist = [[1e9 for _ in range(n)] for _ in range(n)]
    bfs()
    print("Problem {}: {}".format(index, dist[n-1][n-1]))

    index += 1